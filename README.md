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


# Elasticsearch 7.17.3 基本数据结构
    索引 (Index): 索引是 Elasticsearch 中存储数据的逻辑容器，类似于关系型数据库中的“表”。
 特点：
   一个索引可以包含多个文档。
    索引名称必须是小写字母，不能包含特殊字符。

 示例：my_index 是一个索引。

    文档 (Document): 文档是 Elasticsearch 中的基本数据单元，以 JSON 格式存储。类似于关系型数据库中的一行数据。
 特点：

 每个文档属于一个索引，并且有一个唯一的 _id。
 文档可以包含多个字段（fields）。

 示例：

{
"name": "John Doe",
"age": 30,
"city": "New York"
}

    字段 (Field): 文档中的数据项，类似于关系型数据库中的“列”。
特点：
 字段可以是简单类型（如字符串、数字、日期）或复杂类型（如嵌套对象或数组）。
 字段的类型由映射（mapping）定义。

​示例：name, age, city 是文档中的字段。

    映射 (Mapping): 定义字段的数据类型、是否索引、是否存储、是否分词等。
 特点：
 一个索引可以有多个映射。   
 映射定义在索引创建时定义，不能修改。

​示例：

{
"mappings": {
"properties": {
"name": {
"type": "text"
},
"age": {
"type": "integer"
},
"city": {
"type": "keyword"
}
}
}
}    

    集群 (Cluster): 由多个索引组成，通常由一个或多个节点组成。
 特点：
 集群由一个唯一的名称标识，默认端口号为 9200。
 集群中的节点通过集群名称、节点名称和端口号进行通信。

​示例：一个集群包含一个索引 my_index。    

    节点 (Node): 集群中的一个服务器，存储数据并参与集群的索引和搜索功能。
 特点：
 节点可以是数据节点、主节点、协调节点。
 节点通过集群名称、节点名称和端口号进行通信。

​示例：一个集群包含一个数据节点和一个主节点。     

    主节点 (Master Node): 集群中的主节点，负责管理集群的状态，并分配数据到其他节点。
 特点：
 主节点是集群中唯一的主动节点，负责集群的状态管理和数据分配。
 主节点可以是单节点或多节点。

​示例：一个集群包含一个主节点。     

    副本 (Replica): 副本是主节点的复制品，用于提高数据可用性和容错能力。
 特点：
 副本可以是主节点的主动副本或被动副本。
 副本可以是单副本或多副本。

​示例：一个索引 my_index 的主节点有一个副本。     

    客户端 (Client): 与 Elasticsearch 集群通信的应用。
 特点：
 客户端可以是浏览器、命令行工具、API 客户端等。
 客户端通过集群名称、节点名称和端口号进行通信。

​示例：一个客户端通过浏览器访问集群。     

    索引模板 (Index Template): 定义索引的配置，包括映射、设置、别名等。 
 特点：
 索引模板可以应用于多个索引。
 索引模板可以定义多个模板。   

​示例：一个索引模板定义了索引的映射、设置、别名等。     

    别名 (Alias): 索引的别名，可以指向多个索引。
 特点：
 别名可以指向一个或多个索引。
 别名可以帮助简化索引名称的输入。

​示例：一个索引 my_index 的别名是 my_alias。     

    刷新 (Refresh): 刷新是 Elasticsearch 用于将数据从内存刷新到磁盘的过程。
 特点：
 刷新可以手动触发或自动触发。
 刷新可以是实时刷新或异步刷新。

​示例：一个索引 my_index 的刷新是自动触发的。     

    路由 (Routing): 路由是 Elasticsearch 用于将请求路由到正确的节点的过程。
 特点：
 路由可以基于文档的字段值、文档的大小、文档的位置等。
 路由可以帮助提高查询性能。

​示例：一个索引 my_index 的路由基于文档的 _id 值。     

    集群状态 (Cluster State): 集群状态是 Elasticsearch 用于获取集群的当前状态的 API。
 特点：
 集群状态可以获取集群的配置信息、节点信息、索引信息、分片信息等。
 集群状态可以帮助监控集群的运行状态。

​示例：一个客户端通过 API 获取集群状态。     

    集群设置 (Cluster Settings): 集群设置是 Elasticsearch 用于配置集群的全局参数的 API。
 特点：
 集群设置可以设置集群的名称、数据路径、节点名称、绑定地址、HTTP 端口等。
 集群设置可以帮助调整集群的性能和可用性。

​示例：一个客户端通过 API 设置集群名称。     

    节点设置 (Node Settings): 节点设置是 Elasticsearch 用于配置节点的局部参数的 API。    

    元数据 (Metadata): 元数据是 Elasticsearch 中用于存储索引、文档、映射、设置、别名等元信息的部分。
 特点：
 元数据可以帮助 Elasticsearch 快速找到数据。
 元数据可以帮助 Elasticsearch 管理集群。     

​示例：一个索引 my_index 的元数据存储在 Elasticsearch 的 .metadata 索引中。     

    快照 (Snapshot): 快照是 Elasticsearch 用于备份数据的 API。
 特点：
 快照可以帮助用户备份数据。
 快照可以帮助用户恢复数据。

​示例：一个客户端通过 API 创建快照。     

    监控 (Monitoring): 监控是 Elasticsearch 用于监控集群、节点、索引、分片、查询等的 API。
 特点：
 监控可以帮助用户了解集群的运行状态。
 监控可以帮助用户排查问题。

​示例：一个客户端通过 API 获取集群的 CPU、内存、网络等信息。     

    安全 (Security): 安全是 Elasticsearch 用于保护集群的 API。
 特点：
 安全可以帮助用户控制集群的访问权限。
 安全可以帮助用户保护集群的数据安全。     

    分片（Shard）: 分片是 Elasticsearch 中用于存储数据的基本单位。
 特点：
 分片可以分布到多个节点上。
 分片可以横向扩展。
 分片可以提高数据可用性。
 分片可以帮助用户控制数据分布。     

​示例：一个索引 my_index 的分片数为 5。     

    副本（Replica）: 副本是 Elasticsearch 中用于提高数据可用性和容错能力的基本单位。
 特点：
 副本可以提高数据可用性。
 副本可以帮助用户控制数据分布。
 副本可以帮助用户控制数据冗余。     

​示例：一个索引 my_index 的副本数为 1。     

    集群管理 (Cluster Management): 集群管理是 Elasticsearch 用于管理集群的 API。
 特点：
 集群管理可以帮助用户管理集群。
 集群管理可以帮助用户管理节点。
 集群管理可以帮助用户管理索引。     

​示例：一个客户端通过 API 管理集群。     

    自动发现 (Auto-discovery): 自动发现是 Elasticsearch 用于发现新节点的 API。
 特点：
 自动发现可以帮助用户自动添加新节点。
 自动发现可以帮助用户自动分配数据。     

​示例：一个客户端通过 API 自动发现新节点。     

    脚本化 (Scripting): 脚本化是 Elasticsearch 用于执行自定义逻辑的 API。
 特点：
 脚本化可以帮助用户执行复杂的查询。
 脚本化可以帮助用户执行复杂的聚合。     

​示例：一个客户端通过 API 执行自定义逻辑。     

    跨集群复制 (Cross-cluster replication): 跨集群复制是 Elasticsearch 用于复制数据到其他集群的 API。               
 特点：
 跨集群复制可以帮助用户复制数据到其他集群。
 跨集群复制可以帮助用户在不同集群之间进行数据同步。     

​示例：一个客户端通过 API 复制数据到另一个集群。     

    安全 (Security): 安全是 Elasticsearch 用于保护集群的 API。
 特点：
 安全可以帮助用户控制集群的访问权限。
 安全可以帮助用户保护集群的数据安全。     

    全文搜索 (Full-text search): 全文搜索是 Elasticsearch 用于搜索数据的 API。
 特点：
 全文搜索可以帮助用户搜索文档。
 全文搜索可以帮助用户找到相关文档。     

​示例：一个客户端通过 API 搜索文档。     

    分析器 (Analyzers): 分析器是 Elasticsearch 用于分词、分析数据的 API。
 特点：
 分析器可以帮助用户分词。
 分析器可以帮助用户分析数据。     

​示例：一个客户端通过 API 分词和分析数据。     

    聚合 (Aggregations): 聚合是 Elasticsearch 用于聚合数据的 API。
 特点：
 聚合可以帮助用户聚合数据。
 聚合可以帮助用户分析数据。     

​示例：一个客户端通过 API 聚合数据。     

    排序 (Sorting): 排序是 Elasticsearch 用于排序数据的 API。
 特点：
 排序可以帮助用户排序数据。
 排序可以帮助用户分析数据。     

​示例：一个客户端通过 API 排序数据。     

    过滤 (Filtering): 过滤是 Elasticsearch 用于过滤数据的 API。
 特点：
 过滤可以帮助用户过滤数据。
 过滤可以帮助用户分析数据。     

​示例：一个客户端通过 API 过滤数据。     

    脚本化 (Scripting): 脚本化是 Elasticsearch 用于执行自定义逻辑的 API。     
地理位置 (Geo-location): 地理位置是 Elasticsearch 用于处理地理位置数据的 API。
 特点：
 地理位置可以帮助用户处理地理位置数据。
 地理位置可以帮助用户分析数据。     

​示例：一个客户端通过 API 处理地理位置数据。     

    地理距离 (Geo-distance): 地理距离是 Elasticsearch 用于计算地理位置距离的 API。
 特点：
 地理距离可以帮助用户计算地理位置距离。
 地理距离可以帮助用户分析数据。     

​示例：一个客户端通过 API 计算地理位置距离。     

    地理围栏 (Geo-fencing): 地理围栏是 Elasticsearch 用于处理地理围栏数据的 API。
 特点：
 地理围栏可以帮助用户处理地理围栏数据。
 地理围栏可以帮助用户分析数据。     

​示例：一个客户端通过 API 处理地理围栏数据。     

    地理网格 (Geo-grid): 地理网格是 Elasticsearch 用于处理地理网格数据的 API。
 特点：
 地理网格可以帮助用户处理地理网格数据。
 地理网格可以帮助用户分析数据。     

​示例：一个客户端通过 API 处理地理网格数据。     

    地理聚合 (Geo-aggs): 地理聚合是 Elasticsearch 用于处理地理聚合数据的 API。
 特点：
 地理聚合可以帮助用户处理地理聚合数据。
 地理聚合可以帮助用户分析数据。     

​示例：一个客户端通过 API 处理地理聚合数据。     

    地理编码 (Geo-coding): 地理编码是 Elasticsearch 用于处理地理编码数据的 API。
 特点：
 地理编码可以帮助用户处理地理编码数据。
 地理编码可以帮助用户分析数据。     

​示例：一个客户端通过 API 处理地理编码数据。     

    地理邻接 (Geo-neighbors): 地理邻接是 Elasticsearch 用于处理地理邻接数据的 API。
 特点：
 地理邻接可以帮助用户处理地理邻接数据。
 地理邻接可以帮助用户分析数据。     

​示例：一个客户端通过 API 处理地理邻接数据。     

    地理距离 (Geo-distance): 地理距离是 Elasticsearch 用于计算地理位置距离的 API。               


