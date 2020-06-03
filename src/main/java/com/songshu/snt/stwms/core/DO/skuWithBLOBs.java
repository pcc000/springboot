package com.songshu.snt.stwms.core.DO;

public class skuWithBLOBs extends sku {
    private String imageText;

    private String extAtt;

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText == null ? null : imageText.trim();
    }

    public String getExtAtt() {
        return extAtt;
    }

    public void setExtAtt(String extAtt) {
        this.extAtt = extAtt == null ? null : extAtt.trim();
    }
}