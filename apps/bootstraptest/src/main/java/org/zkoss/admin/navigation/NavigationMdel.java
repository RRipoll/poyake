package org.zkoss.admin.navigation;

public class NavigationMdel {
    public static final String DASHBOARD_ECOMMERCE_ZUL = "/ecommerce/ecommerce.zul";
    public static final String DASHBOARD_PROJECT_ZUL = "/project/project.zul";
    public static final String CONTENT1_ZUL = "/content1.zul";
    public static final String CONTENT2_ZUL = "/content2.zul";
    public static final String BLANK_ZUL = "/blank.zul";

    private String contentUrl = DASHBOARD_ECOMMERCE_ZUL;

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
}
