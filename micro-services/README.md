
## Nacos 

- 官網連結
    - https://nacos.io/docs/latest/quickstart/quick-start-docker/?spm=5238cd80.2ef5001f.0.0.3f613b7cBmPXPz

-  Nacos控制台页面
    - link：http://127.0.0.1:8848/nacos/

- 

## Seata

- SQL
    - https://github.com/apache/incubator-seata/blob/1.7.0/script/server/db/postgresql.sql
    
- 設定檔
    - file.conf - Seata Server Configuration
    - store.conf - Transaction Store Configuration
    - registry.conf - Seata Registry Configuration

- seata with spring jpa example code
    - https://github.com/apache/incubator-seata-samples

## Actuator

- 查看 JVM 内存使用情况：
    - jvm.memory.used: JVM 使用的内存量。
        - curl http://localhost:8081/actuator/metrics/jvm.memory.used
    - jvm.memory.committed: JVM 已分配的内存量。
        - curl http://localhost:8081/actuator/metrics/jvm.memory.committed
    - jvm.memory.max: JVM 最大内存量。
        - curl http://localhost:8081/actuator/metrics/jvm.memory.max

- 查看系统 CPU 使用情况：
    - system.cpu.usage: 系统 CPU 使用率。
        - curl http://localhost:8081/actuator/metrics/system.cpu.usage
    - system.cpu.count: CPU 核心数。
        - curl http://localhost:8081/actuator/metrics/system.cpu.count
    - system.load.average.1m: 过去 1 分钟的平均 CPU 负载。
        - curl http://localhost:8081/actuator/metrics/system.load.average.1m

- 查看磁盘空间使用情况：
    - disk.free: 剩余磁盘空间。
        - curl http://localhost:8081/actuator/metrics/disk.free
    - disk.total: 总磁盘空间。
        - curl http://localhost:8081/actuator/metrics/disk.total

## Sentinel


