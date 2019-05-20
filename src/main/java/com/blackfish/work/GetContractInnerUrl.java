package com.blackfish.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.blackfish.java.util.common.JsonUtil;
import org.apache.commons.codec.binary.Base64;


public class GetContractInnerUrl {
	
	public String version ="2.0";
	
	public String systemId ="ctm";
	
	public String contractId;
	
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public final static String urlHead ="http://api.ctm.fmc.blackfi.sh/ctm/contract/downloadById?";
	
	@SuppressWarnings("unused")
	public static StringBuilder readFile(String fileName){
		File file = new File(fileName);
		BufferedReader  reader = null;
		StringBuilder builder = new StringBuilder();
        try {
        	if(file.exists()){
        		reader = new BufferedReader(new FileReader(file));
        	}else{
        		System.out.println("找不到指定文件");
        		return null;
        	}
            String tempString = "";
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                builder.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return builder;
	}
	
	public static void writeFile(StringBuilder str,String fileName){
		FileOutputStream fop = null;  
        File file;  
        try {  
            file = new File(fileName);  
            fop = new FileOutputStream(file);  
            if (!file.exists()) {  
                file.createNewFile();  
            }  
            byte[] contentInBytes = str.toString().getBytes();  
            fop.write(contentInBytes);  
            fop.flush();  
            fop.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (fop != null) {  
                    fop.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
	}
	
	public static void main(String[] arg) throws Exception{
		
//		StringBuilder builder = GetContractInnerUrl.readFile("C:\\Users\\chengchengpeng\\Desktop\\pcc合同\\test\\test.txt");
//		if(builder == null){
//			return ;
//		}
		String[] lists = "11905171461443079,11905171384211485".toString().split(",");
		StringBuilder resultBuilder = new StringBuilder();
        for(String str : lists){
        	GetContractInnerUrl test = new GetContractInnerUrl();
    		test.setContractId(str);
    		String result = JsonUtil.toString(test);
    		String stri =new String(Base64.encodeBase64(result.getBytes("ISO-8859-1")), "ISO-8859-1");
    		resultBuilder.append(str+" "+GetContractInnerUrl.urlHead+stri+"\n");
    		System.out.println(str+" "+GetContractInnerUrl.urlHead+stri);
    	}
//        GetContractInnerUrl.writeFile(resultBuilder,"C:\\Users\\chengchengpeng\\Desktop\\pcc合同\\test\\testUrl.txt");
	}

}
