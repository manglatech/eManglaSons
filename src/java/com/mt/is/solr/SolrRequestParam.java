package com.mt.is.solr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mt.is.solr.config.SolrFilterQueryConfig;

public class SolrRequestParam {
	
	private Map<String, String> reqParams = new HashMap<String, String>();
	private List<Object> list = new ArrayList<Object>();
	private Integer maxResult;
	private List<SolrFilterQueryConfig> fq = new ArrayList<SolrFilterQueryConfig>();
	private boolean clearConfigFQ = false;
	private String resultType;
	private List<String> disabledQueryIds = new ArrayList<String>();
	
	public Map<String, String> getReqParams() {
		return reqParams;
	}

	public void setReqParams(Map<String, String> reqParams) {
		this.reqParams = reqParams;
	}
	
	public List<Object> getList() {
		return list;
	}
	
	public void setList(List<Object> list) {
		this.list = list;
	}

	public Integer getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	
	public List<SolrFilterQueryConfig> getFq() {
		return fq;
	}
	public void setFq(List<SolrFilterQueryConfig> fq) {
		this.fq = fq;
	}
	public boolean isClearConfigFQ() {
		return clearConfigFQ;
	}

	public void setClearConfigFQ(boolean clearConfigFQ) {
		this.clearConfigFQ = clearConfigFQ;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public List<String> getDisabledQueryIds() {
		return disabledQueryIds;
	}
	public void setDisabledQueryIds(List<String> disabledQueryIds) {
		this.disabledQueryIds = disabledQueryIds;
	}
}
