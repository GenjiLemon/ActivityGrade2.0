package com.laoluoli.java.activitygrade.service.impl;

import com.laoluoli.java.activitygrade.dao.RuleDao;
import com.laoluoli.java.activitygrade.domain.Rule;
import com.laoluoli.java.activitygrade.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.laoluoli.java.activitygrade.utils.ObjectCombine.combineSydwCore;

@Service("ruleService")
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleDao ruleDao;

    @Override
    public List<Rule> getListByActivityid(Integer activityid) {
        return ruleDao.findListByActivityid(activityid);
    }

    @Override
    public Boolean createRule(Rule rule) {
        return ruleDao.save(rule) == 1;
    }

    @Override
    public Boolean updateRule(Rule rule) {
        //数据库拿到已有数据
        Rule r = ruleDao.findById(rule.getId());
        //合并对象，避免数据缺失造成dao层报错
        combineSydwCore(rule, r);
        return ruleDao.update(r) == 1;
    }

    @Override
    public Boolean deleteRule(Integer id) {
        return ruleDao.delete(id) == 1;
    }

    @Override
    public Boolean hasRule(Integer id) {
        return ruleDao.findById(id) != null;
    }
}
