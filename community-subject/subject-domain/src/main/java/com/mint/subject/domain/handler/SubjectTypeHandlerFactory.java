package com.mint.subject.domain.handler;

import com.mint.subject.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mint
 * @Create 2024/8/30
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();

    public SubjectTypeHandler getHandler(int subjectType) {
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        return handlerMap.get(subjectInfoTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        subjectTypeHandlerList.forEach(
            handler -> handlerMap.put(handler.getHandlerType(), handler)
        );
    }
}
