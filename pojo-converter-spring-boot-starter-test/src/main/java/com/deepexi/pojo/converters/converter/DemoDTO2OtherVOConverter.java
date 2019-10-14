package com.deepexi.pojo.converters.converter;

import com.deepexi.pojo.converters.model.dto.DemoDTO;
import com.deepexi.pojo.converters.model.vo.OtherVO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DemoDTO2OtherVOConverter implements Converter<DemoDTO, OtherVO> {

    @Override
    public OtherVO convert(DemoDTO source) {
        OtherVO target = new OtherVO();
        BeanUtils.copyProperties(source, target);
        target.setCurrentTime(new Date().getTime());
        return target;
    }
}
