# spring boot下ebean orm 对mysql操作 和 spring data mongo数据操作

#### ebean 插件
```bash
#安装
https://ebean.io/docs/getting-started/intellij-idea

#idea启用插件
菜单 -> Build -> Ebean enhancement 勾选
```

#### docker安装mongo
```bash
docker run -d --network nets --name mongo -p 27017:27017 --restart=unless-stopped -v /etc/localtime:/etc/localtime -v /data/docker/mongodb/data:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=123456 mongo
```

#### docker安装mysql
```bash
docker run --name mysql --restart=unless-stopped -v /etc/localtime:/etc/localtime -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 -d mysql
```

#### mongo初始化
```bash
#创建数据库
use http_log
show dbs

#创建用户
use http_log
db.createUser({user:"log",pwd:"123456",roles:[{role:"dbOwner",db:"http_log"}]})

#项目运行创建data_http_log表

#查询
db.data_http_log.find()

#正则模糊查询
db.data_http_log.findOne({"response":/chNo/})
```

