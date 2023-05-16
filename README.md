# seata-demo
seata实现分布式事务，使用nacos做配置中心

参考博客：https://blog.csdn.net/qq_37354060/article/details/124186474

安装Seata过程中遇到的一些问题：
1、
![1684252876666](https://github.com/Janice0721/seata-demo/assets/93896107/b0fca7bd-45f3-4e91-a54c-96ad9125ac73)
解决：在jre的安装目录下创建server文件夹，并将jvm.dll复制进去即可
![1684252983833](https://github.com/Janice0721/seata-demo/assets/93896107/0a50828a-e07e-4dc7-b00c-82d72ea10815)

2、![1684253043159](https://github.com/Janice0721/seata-demo/assets/93896107/0619cd98-134b-4f26-9b1b-b2f091bfc106)
解决：是因为seata的lib下没有对应的mysql驱动，只需要导入就好了
![1684253127846](https://github.com/Janice0721/seata-demo/assets/93896107/eaef67dd-c5a4-4d95-a46e-aa7dbdbaf2a5)
