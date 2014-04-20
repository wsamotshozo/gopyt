--- 
repositories: 
  - 
    flexjson: 
      artifact: "http://repo1.maven.org/maven2/net/sf/flexjson/flexjson/2.1/[module]-[revision].[ext]"
      contains: 
        - net.sf.flexjson -> *
      type: http
  - 
    dwolla-java-sdk: 
      - 
        zenexity: 
          artifact: "http://www.zenexity.com/repo/[module]-[revision].[ext]"
          contains: 
            - com.zenexity -> *
          type: http
      - 
        artifact: "http://search.maven.org/remotecontent?filepath=com/dwolla/dwolla-java-sdk/1.1.8/[module]-[revision].[ext]"
        contains: 
          - com.dwolla -> *
        dwolla: 
          type: http
require: 
  - play -> play [1.2.4]
  - play -> siena 2.0.7
  - play -> gae 1.6.0"
  - play -> dwolla"
  - play -> dwolla-java-sdk 1.1.8
