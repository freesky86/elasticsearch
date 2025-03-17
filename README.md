# elasticsearch
Spring Boot + ElasticSearch

D:\Software\ElasticSearch\elasticsearch-7.17.3

# 1.本机配置ES_JAVA_HOME指向JDK17
# 2.启动Elasticsearch
命令行到elasticsearch zip解压目录的\bin 目录下，输入 elasticsearch
# 3.浏览器访问 http://localhost:9200/ 能看到json就表示启动成功
# 4.POSTMAN通过RESTful接口创建index(PUT)，添加document(POST)，查询document(GET)，删除index(DELETE)
# 5.启动 kibana(注意要和elasticsearch版本一致)，浏览器访问 http://localhost:5601 ，搜索 Dev Tools，可查询index里面的document
D:\Software\ElasticSearch\kibana-7.17.3-windows-x86_64
命令行到kibana zip解压目录的 \bin 目录下， 输入 kibana
*** 注意：Kibana版本要和Elasticsearch版本一致。***


# Elasticsearch 基本数据结构
    字段 (Field): 类似于关系型数据库中的字段，是数据的最小单位。

    文档 (Document): 由多个字段组成，类似于关系型数据库中的一行数据。

    类型 (Type): 由多个文档组成，类似于关系型数据库中的表。在 Elasticsearch 7.x 版本中，一个索引下只能有一个类型。

    索引 (Index): 由多个类型组成，类似于关系型数据库中的数据库。

    集群 (Cluster): 由多个索引组成，通常由一个或多个节点组成。

