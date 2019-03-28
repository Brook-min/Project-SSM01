package com.newer.pojo.sys.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultationExample implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsultationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andKeeponidIsNull() {
            addCriterion("keeponid is null");
            return (Criteria) this;
        }

        public Criteria andKeeponidIsNotNull() {
            addCriterion("keeponid is not null");
            return (Criteria) this;
        }

        public Criteria andKeeponidEqualTo(Integer value) {
            addCriterion("keeponid =", value, "keeponid");
            return (Criteria) this;
        }

        public Criteria andKeeponidNotEqualTo(Integer value) {
            addCriterion("keeponid <>", value, "keeponid");
            return (Criteria) this;
        }

        public Criteria andKeeponidGreaterThan(Integer value) {
            addCriterion("keeponid >", value, "keeponid");
            return (Criteria) this;
        }

        public Criteria andKeeponidGreaterThanOrEqualTo(Integer value) {
            addCriterion("keeponid >=", value, "keeponid");
            return (Criteria) this;
        }

        public Criteria andKeeponidLessThan(Integer value) {
            addCriterion("keeponid <", value, "keeponid");
            return (Criteria) this;
        }

        public Criteria andKeeponidLessThanOrEqualTo(Integer value) {
            addCriterion("keeponid <=", value, "keeponid");
            return (Criteria) this;
        }

        public Criteria andKeeponidIn(List<Integer> values) {
            addCriterion("keeponid in", values, "keeponid");
            return (Criteria) this;
        }

        public Criteria andKeeponidNotIn(List<Integer> values) {
            addCriterion("keeponid not in", values, "keeponid");
            return (Criteria) this;
        }

        public Criteria andKeeponidBetween(Integer value1, Integer value2) {
            addCriterion("keeponid between", value1, value2, "keeponid");
            return (Criteria) this;
        }

        public Criteria andKeeponidNotBetween(Integer value1, Integer value2) {
            addCriterion("keeponid not between", value1, value2, "keeponid");
            return (Criteria) this;
        }

        public Criteria andConsultationidIsNull() {
            addCriterion("consultationid is null");
            return (Criteria) this;
        }

        public Criteria andConsultationidIsNotNull() {
            addCriterion("consultationid is not null");
            return (Criteria) this;
        }

        public Criteria andConsultationidEqualTo(Integer value) {
            addCriterion("consultationid =", value, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationidNotEqualTo(Integer value) {
            addCriterion("consultationid <>", value, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationidGreaterThan(Integer value) {
            addCriterion("consultationid >", value, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("consultationid >=", value, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationidLessThan(Integer value) {
            addCriterion("consultationid <", value, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationidLessThanOrEqualTo(Integer value) {
            addCriterion("consultationid <=", value, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationidIn(List<Integer> values) {
            addCriterion("consultationid in", values, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationidNotIn(List<Integer> values) {
            addCriterion("consultationid not in", values, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationidBetween(Integer value1, Integer value2) {
            addCriterion("consultationid between", value1, value2, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationidNotBetween(Integer value1, Integer value2) {
            addCriterion("consultationid not between", value1, value2, "consultationid");
            return (Criteria) this;
        }

        public Criteria andConsultationnameIsNull() {
            addCriterion("consultationname is null");
            return (Criteria) this;
        }

        public Criteria andConsultationnameIsNotNull() {
            addCriterion("consultationname is not null");
            return (Criteria) this;
        }

        public Criteria andConsultationnameEqualTo(String value) {
            addCriterion("consultationname =", value, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameNotEqualTo(String value) {
            addCriterion("consultationname <>", value, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameGreaterThan(String value) {
            addCriterion("consultationname >", value, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameGreaterThanOrEqualTo(String value) {
            addCriterion("consultationname >=", value, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameLessThan(String value) {
            addCriterion("consultationname <", value, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameLessThanOrEqualTo(String value) {
            addCriterion("consultationname <=", value, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameLike(String value) {
            addCriterion("consultationname like", value, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameNotLike(String value) {
            addCriterion("consultationname not like", value, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameIn(List<String> values) {
            addCriterion("consultationname in", values, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameNotIn(List<String> values) {
            addCriterion("consultationname not in", values, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameBetween(String value1, String value2) {
            addCriterion("consultationname between", value1, value2, "consultationname");
            return (Criteria) this;
        }

        public Criteria andConsultationnameNotBetween(String value1, String value2) {
            addCriterion("consultationname not between", value1, value2, "consultationname");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeIsNull() {
            addCriterion("consultationtime is null");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeIsNotNull() {
            addCriterion("consultationtime is not null");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeEqualTo(Date value) {
            addCriterion("consultationtime =", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeNotEqualTo(Date value) {
            addCriterion("consultationtime <>", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeGreaterThan(Date value) {
            addCriterion("consultationtime >", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("consultationtime >=", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeLessThan(Date value) {
            addCriterion("consultationtime <", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeLessThanOrEqualTo(Date value) {
            addCriterion("consultationtime <=", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeIn(List<Date> values) {
            addCriterion("consultationtime in", values, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeNotIn(List<Date> values) {
            addCriterion("consultationtime not in", values, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeBetween(Date value1, Date value2) {
            addCriterion("consultationtime between", value1, value2, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeNotBetween(Date value1, Date value2) {
            addCriterion("consultationtime not between", value1, value2, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andStudenttypeIsNull() {
            addCriterion("studenttype is null");
            return (Criteria) this;
        }

        public Criteria andStudenttypeIsNotNull() {
            addCriterion("studenttype is not null");
            return (Criteria) this;
        }

        public Criteria andStudenttypeEqualTo(String value) {
            addCriterion("studenttype =", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeNotEqualTo(String value) {
            addCriterion("studenttype <>", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeGreaterThan(String value) {
            addCriterion("studenttype >", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("studenttype >=", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeLessThan(String value) {
            addCriterion("studenttype <", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeLessThanOrEqualTo(String value) {
            addCriterion("studenttype <=", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeLike(String value) {
            addCriterion("studenttype like", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeNotLike(String value) {
            addCriterion("studenttype not like", value, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeIn(List<String> values) {
            addCriterion("studenttype in", values, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeNotIn(List<String> values) {
            addCriterion("studenttype not in", values, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeBetween(String value1, String value2) {
            addCriterion("studenttype between", value1, value2, "studenttype");
            return (Criteria) this;
        }

        public Criteria andStudenttypeNotBetween(String value1, String value2) {
            addCriterion("studenttype not between", value1, value2, "studenttype");
            return (Criteria) this;
        }

        public Criteria andRemindtimeIsNull() {
            addCriterion("remindtime is null");
            return (Criteria) this;
        }

        public Criteria andRemindtimeIsNotNull() {
            addCriterion("remindtime is not null");
            return (Criteria) this;
        }

        public Criteria andRemindtimeEqualTo(Date value) {
            addCriterion("remindtime =", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeNotEqualTo(Date value) {
            addCriterion("remindtime <>", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeGreaterThan(Date value) {
            addCriterion("remindtime >", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remindtime >=", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeLessThan(Date value) {
            addCriterion("remindtime <", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeLessThanOrEqualTo(Date value) {
            addCriterion("remindtime <=", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeIn(List<Date> values) {
            addCriterion("remindtime in", values, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeNotIn(List<Date> values) {
            addCriterion("remindtime not in", values, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeBetween(Date value1, Date value2) {
            addCriterion("remindtime between", value1, value2, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeNotBetween(Date value1, Date value2) {
            addCriterion("remindtime not between", value1, value2, "remindtime");
            return (Criteria) this;
        }

        public Criteria andProcessIsNull() {
            addCriterion("process is null");
            return (Criteria) this;
        }

        public Criteria andProcessIsNotNull() {
            addCriterion("process is not null");
            return (Criteria) this;
        }

        public Criteria andProcessEqualTo(String value) {
            addCriterion("process =", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotEqualTo(String value) {
            addCriterion("process <>", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessGreaterThan(String value) {
            addCriterion("process >", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessGreaterThanOrEqualTo(String value) {
            addCriterion("process >=", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessLessThan(String value) {
            addCriterion("process <", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessLessThanOrEqualTo(String value) {
            addCriterion("process <=", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessLike(String value) {
            addCriterion("process like", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotLike(String value) {
            addCriterion("process not like", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessIn(List<String> values) {
            addCriterion("process in", values, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotIn(List<String> values) {
            addCriterion("process not in", values, "process");
            return (Criteria) this;
        }

        public Criteria andProcessBetween(String value1, String value2) {
            addCriterion("process between", value1, value2, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotBetween(String value1, String value2) {
            addCriterion("process not between", value1, value2, "process");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}