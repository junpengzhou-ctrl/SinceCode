###  springboot 整合mybatis   

1. 项目所需要使用的依赖

   ```xml
   <dependencies>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
           </dependency>
   
           <dependency>
               <groupId>org.mybatis.spring.boot</groupId>
               <artifactId>mybatis-spring-boot-starter</artifactId>
               <version>2.1.3</version>
           </dependency>
           <!--     分页插件   -->
           <dependency>
               <groupId>com.github.pagehelper</groupId>
               <artifactId>pagehelper-spring-boot-starter</artifactId>
               <version>1.3.0</version>
           </dependency>
           <!--  druid数据源      -->
           <dependency>
               <groupId>com.alibaba</groupId>
               <artifactId>druid</artifactId>
               <version>1.2.4</version>
           </dependency>
   
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
           </dependency>
   
   
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-devtools</artifactId>
               <scope>runtime</scope>
               <optional>true</optional>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-test</artifactId>
               <scope>test</scope>
           </dependency>
       </dependencies>
   
       <build>
           <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
               </plugin>
           </plugins>
       </build>
   ```

2. 配置数据源及mybatis相关配置 

   ```yml
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       type: com.alibaba.druid.pool.DruidDataSource
       username: root
       password: 111
       url: jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT
   
   
   # 对日志的配置
   logging:
     file:
       name: log/out.log
     level:
       root: info
       wuhobin: debug
   
   
   mybatis:
     mapper-locations: classpath:/mybatis/*.xml
     type-aliases-package: wuhobin.pojo
   
   ```

   

####   常用注解 

1. ```java
   @Mapper
   // 使用这个注解表示这是一个mybatis的mapper类
   @Component
   // 泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。    
   @Repository
   // 用于dao层 用于标注数据访问组件，即dao层 
   @Service
   // 用于标注业务层组件 
   @Controller
   // 用于标注控制层组件(如struts中的action) 
   // 以上四个注解的作用都是将相应的类注入到spring容器中
   
   ```



###    Springboot数据访问操作

1. 查询所有用户

   2. 编写UserDao接口

   ```java
   @Mapper
   @Repository
   public interface UserDao {
       public List<User> listUser();   // 查询所有用户 
   }
   ```

   2. mapper.xml文件编写接口对应的sql语句

   ```xml
   <select id="listUser" resultType="wuhobin.pojo.User">
       select * from mybatis.user
   </select>
   ```

   2.3. 

2. 根据id查询用户

3. 根据用户名查询

4. 增加用户

5. 根据id删除用户

6. 更新用户





#### 分页页面的代码

```html
<div class="ui attached segment" >
            <table class="m-mobile-wide" width="425px">
                <tbody>
                <tr align="center">
                    <td>
                        <a th:href="@{/(pageNum=${page.pageNum-1})}"  class="ui button basic mini" th:unless="${page.isFirstPage}">上一页</a>
                    </td>
                    <td>
                        第
                        <h8 th:text="${page.pageNum}">2</h8>
                        页/共
                        <h8 th:text="${page.pages}">4</h8>
                        页
                        共
                        <h8 th:text="${page.total}">29</h8>
                        条
                    </td>
                    <td>
                        <form name="pageForm" th:action="@{/}" method="get">
                            <div class="ui mini input ">
                                <input type="text" class="m-bg" name="pageNum" placeholder="页码" style="width: 50px!important; height: 27.76px!important;" required>
                                <button type="submit" style="font-size: 11px!important;width: 30px!important; height: 0px!important; border: none;margin: 5px;padding: 0;" class="button mini">
                                    跳转
                                </button>
                            </div>
                        </form>
                    </td>
                    <td> &nbsp;</td>
                    <td  style="float: right">
                        <a th:href="@{/(pageNum=${page.pageNum+1})}" class="ui button basic mini " style="float: right;" th:unless="${page.isLastPage}">下一页</a>
                    </td>
                </tr>
                </tbody>
            </table>
    </div>
```





错误消息 

```html
<div class="ui success  message m-bg" th:unless="${#strings.isEmpty(message)}">
    <i class="close icon"></i>
    <div class="header">提示：</div>
    <p th:text="${message}"></p>
</div>
```

```javascript
$(".message .close").on('click',function () {
    $(this).closest(".message")
        .transition("fade");
})
```

