package cn.itcast.order.controller;

import cn.itcast.order.service.OrderService;
import cn.itcast.order.service.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

   private  final OrderService orderService;

    @GetMapping("{orderId}")
    public ResponseEntity<OrderDTO> queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return ResponseEntity.ok(orderService.queryOrderById(orderId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> queryAll() {
        // 查询全部订单信息
        return ResponseEntity.ok(orderService.queryAll());
    }

    @GetMapping("query")
    public String queryOrder () {
        orderService.queryGoods();
        System.out.println("查询订单");
        return "查询订单成功";
    }

    @GetMapping("save")
    public String saveOrder () {
        orderService.queryGoods();
        System.out.println("新增订单");
        return "新增订单成功";
    }

    @GetMapping("update")
    public String updateOrder () {
        return "更新订单成功";
    }
}
