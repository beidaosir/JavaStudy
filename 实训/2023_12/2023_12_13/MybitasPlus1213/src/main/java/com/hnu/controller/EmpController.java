package com.hnu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hnu.exception.AppException;
import com.hnu.exception.AppExceptionCodeMsg;
import com.hnu.po.Emp;
import com.hnu.query.EmpQuery;
import com.hnu.service.IEmpService;
import com.hnu.vo.ResponseObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 *
 *  跨域处理
 *   @CrossOrigin  当前Controller中有效
 * </p>
 *
 * @author lee
 * @since 2023-12-17
 */
//@CrossOrigin
@RestController
@RequestMapping("/emp")
@Api(value = "员工的API",description="员工相关的CRUD功能")
public class EmpController {

    @Autowired
    IEmpService empService;

    @ApiOperation(value = "添加或修改员工" )
    @PostMapping
    public ResponseObj saveOrUpdate(@RequestBody Emp emp){

        if (emp==null){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        if ("".equals(emp.getEname())){
            throw new AppException(AppExceptionCodeMsg.REQUEST_PARAM_EMPTY);
        }

        boolean b = empService.saveOrUpdate(emp);
        return b?ResponseObj.SUCCESS("更新员工信息成功"):ResponseObj.ERROR(20001,"更新员工信息失败");
    }

    @ApiOperation(value = "删除员工" )
    @DeleteMapping("/{id}")
    public ResponseObj delete(@PathVariable("id") Integer empno){
        boolean b = empService.removeById(empno);
        return b?ResponseObj.SUCCESS("删除员工信息成功"):ResponseObj.ERROR(20001,"删除员工信息失败");
    }

    @ApiOperation(value = "通过编号查询员工" )
    @GetMapping("/{id}")
    public ResponseObj getById(@PathVariable("id") Integer empno){
        Emp emp = empService.getById(empno);
        return emp!=null?ResponseObj.SUCCESS(emp):ResponseObj.ERROR(20002,"没有查到相关的员工信息");
    }

    @ApiOperation(value = "分页查询员工" )
    @PostMapping("/page")
    public ResponseObj page(@RequestBody EmpQuery empQuery){

        QueryWrapper queryWrapper = new QueryWrapper();
        if(empQuery.getEname()!=null){
            queryWrapper.like("ename",empQuery.getEname());
        }

        IPage<Emp> empPage = new Page<>(empQuery.getCurrent(),empQuery.getSize());
        IPage<Emp> page = empService.page(empPage,queryWrapper);
        return ResponseObj.SUCCESS(page);
    }

}
