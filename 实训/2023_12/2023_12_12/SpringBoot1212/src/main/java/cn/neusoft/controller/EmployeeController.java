package cn.neusoft.controller;

import cn.neusoft.po.Employee;
import cn.neusoft.query.EmployeeQuery;
import cn.neusoft.service.IEmployeeService;
import cn.neusoft.vo.PageBean;
import cn.neusoft.vo.ResponseObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
@Api(value = "员工的API",description="员工相关的CRUD功能")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @ApiOperation(value = "添加或修改" )
    @PostMapping
    public ResponseObj addOrUpdate(@RequestBody Employee employee){
        if (employee.getEmpno()==null){
            boolean add = employeeService.add(employee);
            return add?ResponseObj.SUCCESS("添加员工成功"):ResponseObj.ERROR("添加员工失败");
        }else{
            boolean update = employeeService.update(employee);
            return update?ResponseObj.SUCCESS("修改员工成功"):ResponseObj.ERROR("修改员工失败");
        }
    }

    @ApiOperation(value = "通过ID删除" )
    @DeleteMapping("/{id}")
    public ResponseObj del(@PathVariable("id") Integer empno){
        boolean del = employeeService.del(empno);
        return del?ResponseObj.SUCCESS("删除员工成功"):ResponseObj.ERROR("删除员工失败");
    }

    @ApiOperation(value = "通过ID查询" )
    @GetMapping("/{id}")
    public ResponseObj getById(@PathVariable("id") Integer empno){
        Employee employee = employeeService.getById(empno);
        return ResponseObj.SUCCESS(employee);
    }

    @ApiOperation(value = "分页查询" )
    @PostMapping("/page")
    public ResponseObj getByPage(@RequestBody EmployeeQuery query){
        PageBean<Employee> pageBean = employeeService.getByPage(query);
        return ResponseObj.SUCCESS(pageBean);
    }

}
