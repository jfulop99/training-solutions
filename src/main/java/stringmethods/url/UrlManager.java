package stringmethods.url;

public class UrlManager {
    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    public UrlManager(String url) {
        if (isEmpty(url)) {
            throw new IllegalArgumentException();
        }
        String restUrl = url.trim();
        if (url.indexOf(':') < 0) {
            throw new IllegalArgumentException("Invalid url");
        }
        protocol = url.substring(0, url.indexOf(':'));
        if (protocol == null) {
            throw new IllegalArgumentException();
        }
        protocol = protocol.toLowerCase();
        restUrl = url.substring(url.indexOf(':') + 3);
        if (restUrl == null || restUrl.length() == 0) {
            throw new IllegalArgumentException("Invalid url");
        }
        if (restUrl.indexOf(':') > 0) {
            host = restUrl.substring(0, restUrl.indexOf(':'));
            if (restUrl.indexOf('/') > 0) {
                port = Integer.parseInt(restUrl.substring(restUrl.indexOf(':') + 1, restUrl.indexOf('/')));
                restUrl = restUrl.substring(restUrl.indexOf('/'));
            }
            else {
                port = Integer.parseInt(restUrl.substring(restUrl.indexOf(':') + 1));
                path = "";
            }
        }
        else {
            host = restUrl.substring(0, restUrl.indexOf('/'));
            restUrl = restUrl.substring(restUrl.indexOf('/'));
        }
        host = host.toLowerCase();
        if (path == null) {
            if (restUrl.indexOf('?') > 0) {
                path = restUrl.substring(0, restUrl.indexOf('?'));
                query = restUrl.substring(restUrl.indexOf('?')+1);
            }
            else {
                path = restUrl;
            }
            path = path.toLowerCase();
        }
    }

    public boolean hasProperty(String key) {
        if (isEmpty(key)) {
            throw new IllegalArgumentException();
        }
        String[] splittedQuery = query.split("\\&");
        boolean contains = false;
        for (String item:splittedQuery) {
            if (item.startsWith(key + "=")) {
                contains = true;
            }
        }
        return contains;
    }

    public String getProperty(String key) {
        if (isEmpty(key)) {
            throw new IllegalArgumentException();
        }
        String[] splittedQuery = query.split("\\&");
        String property = null;
        for (String item:splittedQuery) {
            if (item.startsWith(key)) {
                property = item.split("=")[1];
            }
        }
        return property;
    }

    private boolean isEmpty(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }
}
