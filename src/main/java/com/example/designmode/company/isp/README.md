#接口隔离原则(ISP：Interface Segregation Principle)
定义：使用多个专门的接口，而不使用单一的总接口，即客户端不应该依赖那些它不需要的接口。  

根据接口隔离原则，当一个接口太大时，我们需要将它分割成一些更细小的接口，使用该接口的客户端仅需知道与之相关的方法即可。每一个接口应该承担一种相对独立的角色，不干不该干的事，该干的事都要干。  
看到这里好像接口隔离原则与单一职责原则是相同的。其实接口隔离原则与单一职责原则的审视角度是不相同的，单一职责原则要求的是类和接口职责单一，注重的是职责，这是业务逻辑上的划分，而接口隔离原则要求接口的方法尽量少。  
  
##接口隔离原则是对接口进行规范约束，其包含的以下4层含义：
 * 接口要尽量少。
 * 接口要高内聚。
 * 定制服务。
 * 接口设计师有限度的。 

在使用接口隔离原则时，我们需要注意控制接口的粒度，接口不能太小，如果太小会导致系统中接口泛滥，不利于维护；接口也不能太大，太大的接口将违背接口隔离原则，灵活性较差，使用起来很不方便。一般而言，接口中仅包含为某一类用户定制的方法即可，不应该强迫客户依赖于那些它们不用的方法。

接口隔离原则是对接口的定义，同时也是对类的定义，接口和类尽量使用原子接口或原子类来组装。但是，这个原子该怎么划分是设计模式中的一大难题，在实践中可以根据以下几个规则来衡量.
##最佳实践
 * 一个接口只服务于一个子模块或业务逻辑。
 * 通过业务逻辑压缩接口中的public方法，接口时常去回顾，尽量让接口达到“满身筋骨肉”，而不是“肥嘟嘟”的一大堆方法。
 * 已经被污染了的接口，尽量去修改，若变更的风险较大，则采用适配器模式进行转化处理。
 * 了解环境，拒绝盲从。 环境不同，接口拆分的标准就不同，深入了解业务逻辑，根据实际情况设计接口。