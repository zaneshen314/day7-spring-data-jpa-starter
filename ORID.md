**O (Objective) 
今天我学习了两部分内容：

1、Spring 异常全局处理：

了解了如何使用 @ControllerAdvice 注解来捕获和处理控制器层的异常，并返回统一格式的错误响应。
学习了如何自定义异常处理方法，通过 @ExceptionHandler 注解来处理特定异常，并通过 ResponseEntity 返回错误信息。
2、JPA 实现 ORM：

学习了如何使用 Spring Data JPA 提供的 JpaRepository 和 CrudRepository 来进行基本的数据操作。
了解了如何实现分页查询，并使用 Pageable 和 Page 对数据进行分页显示。
掌握了如何使用 @Query 注解编写自定义查询，以及如何通过 JPA 实现对象关系映射（ORM）。
**R (Reflective)** 
1、关于 Spring 异常处理：
我对 @ControllerAdvice 和 @ExceptionHandler 的用法感到很有帮助。这种方式避免了在每个控制器中重复写异常处理逻辑，而且异常可以统一处理并返回标准化的错误信息。我觉得这样做非常清晰且高效，尤其是在大规模应用中，能够大大简化异常管理。

2、关于 JPA ORM：
对 JPA 的使用感到非常方便，特别是 JpaRepository 提供的基本方法可以减少很多重复代码。

**I (Interpretive)** 
1、Spring 异常处理的价值：
通过全局异常处理，Spring 提供了一种集中化的错误处理方式，避免了分散在各个控制器中的重复代码，并确保了异常处理的统一性。

2、JPA ORM 的优点：
使用 JPA 实现 ORM，让开发者可以专注于业务逻辑，而不用过多关心 SQL 细节。

**D (Decisional)** 
我计划深入探讨如何优化 JPA 查询，尤其是对于复杂查询和多表连接的场景，学习如何高效地使用 @Query 和原生 SQL。
在异常处理方面，我打算研究如何结合 Spring Security 中的异常处理机制，确保整个应用的安全和稳定。
我也希望能进一步理解如何在 Spring Boot 项目中实现全局异常处理与日志记录的结合，做到更好的异常追踪和日志分析
