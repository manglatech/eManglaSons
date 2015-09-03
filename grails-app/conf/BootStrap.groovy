import com.mt.is.domain.Catalog
import com.mt.is.domain.Category
import com.mt.is.domain.CategoryMapping;
import com.mt.is.domain.Product;
import com.mt.is.domain.SKU;
import com.mt.is.domain.rules.DroolsRule;
import com.mt.is.domain.user.Role;
import com.mt.is.domain.user.User;
import com.mt.is.domain.user.UserRole;

class BootStrap {

    def init = { servletContext ->
		def RULE_PROPERTY = "ruleText" // rule or ruleText
		def classLoader = this.class.classLoader
		String rule1 = '''		
		rule "UserName is dhaval"
		when
			$u : User(username == "dhaval")
		then
			System.out.println("User is Dhaval");
		end
		'''
		new DroolsRule((RULE_PROPERTY): rule1, description: "UserName is dhaval", packageName: "user").save()
		String drlText = classLoader.getResourceAsStream("rules/user.drl").text
		new DroolsRule((RULE_PROPERTY): drlText, description: "user.drl").save()
		
		/*def royalWhite = new SKU(
			code: "DC6806-WHIT-D",
			name: "Royal White",
			displayName: "Royal White Paint"
			).save(failOnError:true)
		
		def royalBlack = new SKU(
				code: "DC6806-BLK-D",
				name: "Royal Black",
				displayName: "Royal Black Paint"
				).save(failOnError:true)*/
		
		def royal = new Product(
			name: "Royal Paints",
			displayName: "Royal Paints",
			description: "When using transactions there are important considerations you must take into account with regards to how the underlying persistence session is handled by Hibernate. When a transaction is rolled back the Hibernate session used by GORM is cleared. This means any objects within the session become detached and accessing uninitialized lazy-loaded collections will lead",
			featured:true
			).save(failOnError:true)
		
		def royalWhite = new Product(
				name: "Royal Paints White",
				displayName: "Royal Paints White",
				description: "When using transactions there are important considerations you must take into account with regards to how the underlying persistence session is handled by Hibernate. When a transaction is rolled back the Hibernate session used by GORM is cleared. This means any objects within the session become detached and accessing uninitialized lazy-loaded collections will lead",
				featured:true
				).save(failOnError:true)

	def royalBlack = new Product(
					name: "Royal Paints Black",
					displayName: "Royal Paints Black",
					description: "When using transactions there are important considerations you must take into account with regards to how the underlying persistence session is handled by Hibernate. When a transaction is rolled back the Hibernate session used by GORM is cleared. This means any objects within the session become detached and accessing uninitialized lazy-loaded collections will lead",
					featured:true
					).save(failOnError:true)
	
								
		//royal.addToSku(royalWhite)
		//royal.addToSku(royalBlack)
						
		def paintCategory = new Category(
			name: "Asian Paints", 
			displayName: "Asian Paints").save(failOnError:true)
		
		def interiorColor = new Category(
			name: "Interior Color",
			displayName: "Interior Colors of Asian Paints").save(failOnError:true)
		
		interiorColor.addToProducts(royal);
		interiorColor.addToProducts(royalWhite);
		interiorColor.addToProducts(royalBlack);
		
			
		//paintCategory.childCategories << interiorColor
		//interiorColor.parent << paintCategory
			
		def categoryMapping = new CategoryMapping(
			parent: paintCategory, 
			child: interiorColor).save(failOnError:true)
		
		//println "Asian Paints's SubCategories: ${paintCategory.}"
		//println "Interior Color SubCategories: ${interiorColor.childCategories}"
		
		def cementCategory = new Category(
			name: "Cements",
			displayName: "Cements").save(failOnError:true)
				
		def homeGoodsCategory = new Category(
			name: "Home Goods",
			displayName: "Home Goods").save(failOnError:true)
		
		def manglaSonsCatalog = new Catalog(
			name: "mscatalog",
			displayName: "Mangla Sons Catalog")
		
		manglaSonsCatalog.addToCategories(paintCategory)
		manglaSonsCatalog.addToCategories(cementCategory)
		manglaSonsCatalog.addToCategories(homeGoodsCategory)
		
		manglaSonsCatalog.save(failOnError:true)
		
		
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true, failOnError:true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true, failOnError:true)
  
		def testUser = new User(username: 'dhaval', password: 'dhaval')
		testUser.save(flush: true, failOnError:true)
  
		UserRole.create testUser, adminRole, true
			
    }
    def destroy = {
    }
}
