package com.jbm.framework.mvc.form;

import com.alibaba.fastjson.JSON;
import com.jbm.framework.masterdata.usage.paging.PageForm;
import com.jbm.util.StringUtils;
import com.jbm.util.json.JSONBean;

import java.util.List;
import java.util.Map;

//import com.jbm.framework.metadata.usage.page.PageForm;

/**
 * 前端请求封装类
 *
 * @author wesley.zhang
 */
public class JsonRequestBody extends JSONBean {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private PageForm pageForm;

    public JsonRequestBody() {
        super();
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    /**
     * 默认获取同类名字<br/>
     * 段如果没有会在ROOT节点下查找
     *
     * @param clazz
     * @return
     */
    public <T> T tryGet(Class<T> clazz) {
        return tryGet(StringUtils.uncapitalize(clazz.getSimpleName()), clazz);
    }

    public <T> List<T> tryGetList(Class<T> clazz) {
        return JSON.parseArray(this.toJSONString(), clazz);
    }

    public <T> List<T> getList(String key, Class<T> clazz) {
        return JSON.parseArray(this.getJSONArray(key).toJSONString(), clazz);
    }

    /**
     * 在文本中获取相关字段
     *
     * @param name  字段名称
     * @param clazz 转换类类型
     * @return
     */
    public <T> T tryGet(String name, Class<T> clazz) {
        if (StringUtils.isNotBlank(name) && this.containsKey(name)) {
            return JSON.toJavaObject(this.getJSONObject(name), clazz);
        }
        return JSON.toJavaObject(this, clazz);
    }

    public Map<String, Object> tryToMap() {
        return this;
    }

    public PageForm getPageForm() {
        if (pageForm == null)
            pageForm = this.tryGet("pageForm", PageForm.class);
        return pageForm;
    }


}
