<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Search Result Page</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							ID
						</th>
						<th>
							Name
						</th>
						<th>
							price
						</th>
						<th>
							brand
						</th>
						<th>
							description
						</th>
						<th>
							inStock
						</th>
						<th>
							featured
						</th>
					</tr>
				</thead>
				<tbody>
				
				<g:each status="i" in="${products}" var="product">
				
					<tr>
						<td>
							${i}
						</td>
						<td>
							${product.id}
						</td>
						<td>
							${product.name}
						</td>
						<td>
							${product?.price}
						</td>
						<td>
							${product?.brand}
						</td>
						<td>
							${product?.description}
						</td>
						<td>
							${product?.inStock}
						</td>
						<td>
							${product?.featured}
						</td>						
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</div>
</div>

<g:link action="index"> Search Again !! </g:link>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>