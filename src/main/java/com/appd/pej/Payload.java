package com.appd.pej;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pejman on 17/05/17.
 */
public class Payload implements Serializable {
    private String message;

    private String host;
    public String correlationId = null;
    public String singularityHeader = null;

    public Payload(String string, String host) {
        this.message = string;
        this.host = host;
    }


  public Map<String, String> innerPayload = new ConcurrentHashMap<String, String>();

  public Map<String, String> getInnerPayload()
  {
      return innerPayload;
  }

  public void put(String singularityHeader, String correlationId) {
        this.singularityHeader = singularityHeader;
        this.correlationId = correlationId;
		this.innerPayload.put(this.singularityHeader, this.correlationId);
  }

  public String getCorrId(){
      //String sing = this.singularityHeader;
      if (this.singularityHeader != null){
        return this.innerPayload.get(this.singularityHeader);
      } else
        return "Null";
  }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    */

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
