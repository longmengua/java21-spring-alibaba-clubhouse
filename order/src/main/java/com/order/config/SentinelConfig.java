package com.order.config;

import java.util.Collections;

import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import jakarta.annotation.PostConstruct;

@Component
public class SentinelConfig {
    @PostConstruct
    public void initRules() {
        FlowRule rule = new FlowRule();
        rule.setResource("/getOrder");       // Match the resource name
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);                    // Allow 1 QPS
        rule.setLimitApp("default");

        FlowRuleManager.loadRules(Collections.singletonList(rule));
    }
}
