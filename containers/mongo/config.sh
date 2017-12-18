#!/bin/bash

docker exec -it mongocfg1 bash -c "echo 'rs.initiate({_id: \"mongors1conf\",configsvr: true, members: [{ _id : 0, host : \"mongocfg1\" },{ _id : 1, host : \"mongocfg2\" }, { _id : 2, host : \"mongocfg3\" }]})' | mongo"

docker exec -it mongocfg1 bash -c "echo 'rs.status()' | mongo"

docker exec -it mongors1n1 bash -c "echo 'rs.initiate({_id : \"mongors1\", members: [{ _id : 0, host : \"mongors1n1\" },{ _id : 1, host : \"mongors1n2\" },{ _id : 2, host : \"mongors1n3\" }]})' | mongo"

docker exec -it mongors1n1 bash -c "echo 'rs.status()' | mongo"

docker exec -it mongos1 bash -c "echo 'sh.addShard(\"mongors1/mongors1n1\")' | mongo "

docker exec -it mongos1 bash -c "echo 'sh.status()' | mongo "

docker exec -it mongors1n1 bash -c "echo 'use testDb' | mongo"

docker exec -it mongos1 bash -c "echo 'sh.enableSharding(\"testDb\")' | mongo "

docker exec -it mongors1n1 bash -c "echo 'db.createCollection(\"testDb.testCollection\")' | mongo "

docker exec -it mongos1 bash -c "echo 'sh.shardCollection(\"testDb.testCollection\", {\"shardingField\" : 1})' | mongo "


