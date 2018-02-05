package com.softwore.zgd.partol.controller;

import com.softwore.zgd.activity.common.ResultResp;
import com.softwore.zgd.activity.draw.ActivityTurntableDrawService;
import com.softwore.zgd.activity.draw.bean.ActivityTurntableDrawReq;
import com.softwore.zgd.activity.draw.bean.AwardDrawRecordBean;
import com.softwore.zgd.partol.controller.support.BaseController;
import com.softwore.zgd.partol.controller.support.ResponseData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/2/4.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController extends BaseController {

    private static final Log log = LogFactory.getLog(ActivityController.class);
    @Autowired
    ActivityTurntableDrawService activityTurntableDrawService;

    @GetMapping("/index")
    public String index(){
        return "activity/index";
    }

    @PostMapping("/doDraw")
    public ResponseEntity doDraw(){
        ActivityTurntableDrawReq drawReq=new ActivityTurntableDrawReq();
        drawReq.setUid(Integer.parseInt(getUid()));
        ResultResp<AwardDrawRecordBean> resp= activityTurntableDrawService.doDraw(drawReq);
        ResponseData data=new ResponseData();
        data.setCode(resp.getReturnCodeEnum().getCode());
        data.setMessage(resp.getReturnCodeEnum().getMsg());
        data.setData(resp.getResult());
        return ResponseEntity.ok(data);
    }


}
