package cms.core.wechat.message;

public class ImageMsg extends BaseMsg {

    public String PicUrl;

    public String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picurl) {
        PicUrl = picurl;
    }
}