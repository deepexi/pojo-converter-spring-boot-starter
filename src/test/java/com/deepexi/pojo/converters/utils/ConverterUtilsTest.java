package com.deepexi.pojo.converters.utils;

import com.deepexi.pojo.converter.utils.ConverterUtils;
import com.deepexi.pojo.converters.PojoConverterSpringBootStarterTestApplicationTests;
import com.deepexi.pojo.converters.model.dto.DemoDTO;
import com.deepexi.pojo.converters.model.vo.OtherVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConverterUtilsTest extends PojoConverterSpringBootStarterTestApplicationTests {

    @Autowired
    private ConversionService conversionService;

    private static final int SIZE = 5;

    private static DemoDTO demoDTO;

    private static DemoDTO demoDTONull;

    private static List<DemoDTO> demoDTOs = new ArrayList<>(SIZE);

    @BeforeClass
    public static void setUp() {
        demoDTO = new DemoDTO("1", "张三", "中国广州");

        for (int i = 0; i < 5; i++) {
            DemoDTO dto = new DemoDTO("" + i, "张三" + i, "中国广州" + i);
            demoDTOs.add(dto);
        }
    }

    @Test
    public void setConversionService() {
        Assert.assertNotNull("ConversionService con not be null...", conversionService);
    }

    @Test
    public void convert() {
        Assert.assertNotNull("Description result con not null...", demoDTO.getDescription());
        OtherVO otherVO = ConverterUtils.convert(demoDTO, OtherVO.class);
        Assert.assertNotNull("Convert result con not null...", otherVO);
        Assert.assertEquals(otherVO.getId(), demoDTO.getId());
    }

    @Test
    public void convertError() {
        OtherVO otherVO = ConverterUtils.convert("string", OtherVO.class);
        Assert.assertNull(otherVO.getName());
    }

    @Test
    public void convertNull() {
        OtherVO otherVONull = ConverterUtils.convert(DemoDTO.class, OtherVO.class);
        Assert.assertNull(otherVONull.getId());
        Assert.assertNull(otherVONull.getCurrentTime());
    }

    @Test
    public void convertAll() {
        List<OtherVO> otherVOS = ConverterUtils.convertAll(demoDTOs, OtherVO.class);
        Assert.assertEquals(otherVOS.size(), SIZE);
        for (int i = 0; i < SIZE; i++) {
//            Assert.assertEquals(otherVOS.get(i).getId(), demoDTOs.get(i).getId());
//            Assert.assertEquals(otherVOS.get(i).getName(), demoDTOs.get(i).getName());
            Assert.assertNotNull("日期不为空...", otherVOS.get(i).getCurrentTime());
        }
    }
}