package com.mt.is.solr.services;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.exception.VZWSolrException;
import com.mt.is.solr.processors.SolrRequestProcessorImpl;

public class SolrBasicUpdateOperations {

	private static final String UPDATED_ENTITY_ID = "UpdatedEntityId";
	private static final String DEVICE_ = "DEVICE_";
	private static final String VENDOR_ = "VENDOR_";
	private static final String PROJECT_ = "PROJECT_";
	

	private static final String PRODUCT_DELETE_CONFIG = "deleteDevice";
	private static final String PRODUCT_DELTA_IMPORT_CONFIG = "deltaImportDevice";
	private static final String PRODUCT_FULL_IMPORT_CONFIG = "fullImportDevice";

	private static final String VENDOR_DELETE_CONFIG = "deleteVendor";
	private static final String VENDOR_DELTA_IMPORT_CONFIG = "deltaImportVendor";
	private static final String VENDOR_FULL_IMPORT_CONFIG = "fullImportVendor";

	private static final String PROJECT_DELETE_CONFIG = "deleteProject";
	private static final String PROJECT_DELTA_IMPORT_CONFIG = "deltaImportProject";
	private static final String PROJECT_FULL_IMPORT_CONFIG = "fullImportProject";

	public static final String PRODUCT_TYPE = "PRODUCT";
	public static final String VENDOR_TYPE = "VENDOR";
	public static final String PROJECT_TYPE = "PROJECT";
	
	
	public static void deleteEntity(String entityId, String type) throws VZWSolrException{
		try {
			SolrRequestProcessorImpl processor = SolrRequestProcessorImpl.getInstance();
			SolrRequestParam param = new SolrRequestParam();
			
			if(PRODUCT_TYPE.equalsIgnoreCase(type)){
				param.getReqParams().put("deleteId", DEVICE_+entityId);
				processor.executeSolrReq(PRODUCT_DELETE_CONFIG, param);				
			}else if(VENDOR_TYPE.equalsIgnoreCase(type)){
				param.getReqParams().put("deleteId", VENDOR_+entityId);
				processor.executeSolrReq(VENDOR_DELETE_CONFIG, param);
			}else if(PROJECT_TYPE.equalsIgnoreCase(type)){
				param.getReqParams().put("deleteId", PROJECT_+entityId);
				processor.executeSolrReq(PROJECT_DELETE_CONFIG, param);
			}else{
				throw new VZWSolrException("Cound not found Type :"+type);
			}

			
		} catch (VZWSolrException e) {
			throw e;
		}
	}
	
	public static void deltaImportEntity(String entityId, String type) throws VZWSolrException{
		try {
			
			SolrRequestProcessorImpl processor = SolrRequestProcessorImpl.getInstance();
			SolrRequestParam param = new SolrRequestParam();
			param.getReqParams().put(UPDATED_ENTITY_ID, entityId);
			
			if(PRODUCT_TYPE.equalsIgnoreCase(type)){
				processor.executeSolrReq(PRODUCT_DELTA_IMPORT_CONFIG, param);		
			}else if(VENDOR_TYPE.equalsIgnoreCase(type)){
				processor.executeSolrReq(VENDOR_DELTA_IMPORT_CONFIG, param);
			}else if(PROJECT_TYPE.equalsIgnoreCase(type)){
				processor.executeSolrReq(PROJECT_DELTA_IMPORT_CONFIG, param);
			}else{
				throw new VZWSolrException("Cound not found Type :"+type);
			}
		} catch (VZWSolrException e) {
			throw e;
		}
	}
	
	public static void fullImportEntity(String type) throws VZWSolrException{
		
		try {
			SolrRequestProcessorImpl processor = SolrRequestProcessorImpl.getInstance();
			SolrRequestParam param = new SolrRequestParam();
			
			if(PRODUCT_TYPE.equalsIgnoreCase(type)){
				processor.executeSolrReq(PRODUCT_FULL_IMPORT_CONFIG, param);	
			}else if(VENDOR_TYPE.equalsIgnoreCase(type)){
				processor.executeSolrReq(VENDOR_FULL_IMPORT_CONFIG, param);
			}else if(PROJECT_TYPE.equalsIgnoreCase(type)){
				processor.executeSolrReq(PROJECT_FULL_IMPORT_CONFIG, param);
			}else{
				throw new VZWSolrException("Cound not found Type :"+type);
			}
		} catch (VZWSolrException e) {
			throw e;
		}
	}
}
