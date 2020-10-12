# 01-datasource
01-datasource-mybatisplus:该项目集成mybatisplus

### 常规接口测试请求示例
- 启动服务器后，依次输入以下url，进行接口测试
- 根据ID查询：http://localhost:7010/province/get/1
- 根据条件查询：http://localhost:7010/province/getByCondition?provinceName=西
- 分页查询：http://localhost:7010/province/page?page=3&size=2

### 启用租户
- 1.在yml中将it235.tenant.enable参数设置为true
- 2.在数据库中的teant_id字段提供需要使用的租户ID，默认10000
- 3.接口使用时需在请求头或url参数中拼接租户id
- http://localhost:7010/province/get/1?tenantId=10000