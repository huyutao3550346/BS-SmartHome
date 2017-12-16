BS-SmartHome
=
前言
-
	这个项目是我所在团队的“物联网云平台”毕业设计项目的一部分，本意是作为”物联网云平台“的一个场景下的实现。本着开放、交流和学习的态度，欢迎大家的相互交流!
架构
-
      (因特网)           (串口)  
    ------------树莓派网关 + cc2530  
                            |  
                            |                               传感器或控制器  
                            |(zigbee网络)    (串口透传)    /  
                            |-------------cc2530 + Arduino/-----传感器或控制器  
                            |                             \  
                            |                              传感器或控制器  
                            |  
                            |  
                            |  
                            |                               传感器或控制器  
                            |(zigbee网络)    (串口透传)    /  
                            |-------------cc2530 + Arduino/-----传感器或控制器  
                            |                             \  
                            |                              传感器或控制器  
                            |    	  
                            |------	  
                            |------  
                            |------  
目标
-
  1、以cc2530为zigbee芯片，设计一套用于控制cc2530的命令集，在z-stack2.5.1a上实现解析和执行；Arduino可以通过串口和cc2530进行通信，用来发送控制命令给cc2530，接收命令的返回消息和接收其他zigbee模块发送过来的消息。  
  2、以Arduino unio r3为控制器，使传感器和控制器工作起来，实现具有实际应用价值的家居应用。  
  3、以树莓派3B作为网关，把家居的zigbee网络连接到因特网。物联网网关软件——BSGateway，基于java语言采用OSGi技术进行开发构建，实现BSGateway以下特性：支持热拔插，支持在线升级，具有初级的安全性，具有高可靠性、高可扩展性和高可维护管理性。  
