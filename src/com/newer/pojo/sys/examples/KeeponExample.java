package com.newer.pojo.sys.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KeeponExample implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /***
     * 添加条件字段备案id
     */
    private Integer keeponid;

    public Integer getKepponid() {
        return keeponid;
    }

    public void setKepponid(Integer keeponid) {
        this.keeponid = keeponid;
    }

    public KeeponExample() {
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

        public Criteria andStudentnameIsNull() {
            addCriterion("studentname is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("studentname is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("studentname =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("studentname <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("studentname >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("studentname >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("studentname <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("studentname <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("studentname like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("studentname not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("studentname in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("studentname not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("studentname between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("studentname not between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andInfosourceIsNull() {
            addCriterion("infosource is null");
            return (Criteria) this;
        }

        public Criteria andInfosourceIsNotNull() {
            addCriterion("infosource is not null");
            return (Criteria) this;
        }

        public Criteria andInfosourceEqualTo(String value) {
            addCriterion("infosource =", value, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceNotEqualTo(String value) {
            addCriterion("infosource <>", value, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceGreaterThan(String value) {
            addCriterion("infosource >", value, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceGreaterThanOrEqualTo(String value) {
            addCriterion("infosource >=", value, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceLessThan(String value) {
            addCriterion("infosource <", value, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceLessThanOrEqualTo(String value) {
            addCriterion("infosource <=", value, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceLike(String value) {
            addCriterion("infosource like", value, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceNotLike(String value) {
            addCriterion("infosource not like", value, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceIn(List<String> values) {
            addCriterion("infosource in", values, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceNotIn(List<String> values) {
            addCriterion("infosource not in", values, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceBetween(String value1, String value2) {
            addCriterion("infosource between", value1, value2, "infosource");
            return (Criteria) this;
        }

        public Criteria andInfosourceNotBetween(String value1, String value2) {
            addCriterion("infosource not between", value1, value2, "infosource");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andMarketerIsNull() {
            addCriterion("marketer is null");
            return (Criteria) this;
        }

        public Criteria andMarketerIsNotNull() {
            addCriterion("marketer is not null");
            return (Criteria) this;
        }

        public Criteria andMarketerEqualTo(String value) {
            addCriterion("marketer =", value, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerNotEqualTo(String value) {
            addCriterion("marketer <>", value, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerGreaterThan(String value) {
            addCriterion("marketer >", value, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerGreaterThanOrEqualTo(String value) {
            addCriterion("marketer >=", value, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerLessThan(String value) {
            addCriterion("marketer <", value, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerLessThanOrEqualTo(String value) {
            addCriterion("marketer <=", value, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerLike(String value) {
            addCriterion("marketer like", value, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerNotLike(String value) {
            addCriterion("marketer not like", value, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerIn(List<String> values) {
            addCriterion("marketer in", values, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerNotIn(List<String> values) {
            addCriterion("marketer not in", values, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerBetween(String value1, String value2) {
            addCriterion("marketer between", value1, value2, "marketer");
            return (Criteria) this;
        }

        public Criteria andMarketerNotBetween(String value1, String value2) {
            addCriterion("marketer not between", value1, value2, "marketer");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAssociatesIsNull() {
            addCriterion("associates is null");
            return (Criteria) this;
        }

        public Criteria andAssociatesIsNotNull() {
            addCriterion("associates is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatesEqualTo(String value) {
            addCriterion("associates =", value, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesNotEqualTo(String value) {
            addCriterion("associates <>", value, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesGreaterThan(String value) {
            addCriterion("associates >", value, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesGreaterThanOrEqualTo(String value) {
            addCriterion("associates >=", value, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesLessThan(String value) {
            addCriterion("associates <", value, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesLessThanOrEqualTo(String value) {
            addCriterion("associates <=", value, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesLike(String value) {
            addCriterion("associates like", value, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesNotLike(String value) {
            addCriterion("associates not like", value, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesIn(List<String> values) {
            addCriterion("associates in", values, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesNotIn(List<String> values) {
            addCriterion("associates not in", values, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesBetween(String value1, String value2) {
            addCriterion("associates between", value1, value2, "associates");
            return (Criteria) this;
        }

        public Criteria andAssociatesNotBetween(String value1, String value2) {
            addCriterion("associates not between", value1, value2, "associates");
            return (Criteria) this;
        }

        public Criteria andNameremarkIsNull() {
            addCriterion("nameremark is null");
            return (Criteria) this;
        }

        public Criteria andNameremarkIsNotNull() {
            addCriterion("nameremark is not null");
            return (Criteria) this;
        }

        public Criteria andNameremarkEqualTo(String value) {
            addCriterion("nameremark =", value, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkNotEqualTo(String value) {
            addCriterion("nameremark <>", value, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkGreaterThan(String value) {
            addCriterion("nameremark >", value, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkGreaterThanOrEqualTo(String value) {
            addCriterion("nameremark >=", value, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkLessThan(String value) {
            addCriterion("nameremark <", value, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkLessThanOrEqualTo(String value) {
            addCriterion("nameremark <=", value, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkLike(String value) {
            addCriterion("nameremark like", value, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkNotLike(String value) {
            addCriterion("nameremark not like", value, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkIn(List<String> values) {
            addCriterion("nameremark in", values, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkNotIn(List<String> values) {
            addCriterion("nameremark not in", values, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkBetween(String value1, String value2) {
            addCriterion("nameremark between", value1, value2, "nameremark");
            return (Criteria) this;
        }

        public Criteria andNameremarkNotBetween(String value1, String value2) {
            addCriterion("nameremark not between", value1, value2, "nameremark");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNull() {
            addCriterion("relationship is null");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNotNull() {
            addCriterion("relationship is not null");
            return (Criteria) this;
        }

        public Criteria andRelationshipEqualTo(String value) {
            addCriterion("relationship =", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotEqualTo(String value) {
            addCriterion("relationship <>", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThan(String value) {
            addCriterion("relationship >", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThanOrEqualTo(String value) {
            addCriterion("relationship >=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThan(String value) {
            addCriterion("relationship <", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThanOrEqualTo(String value) {
            addCriterion("relationship <=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLike(String value) {
            addCriterion("relationship like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotLike(String value) {
            addCriterion("relationship not like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipIn(List<String> values) {
            addCriterion("relationship in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotIn(List<String> values) {
            addCriterion("relationship not in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipBetween(String value1, String value2) {
            addCriterion("relationship between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotBetween(String value1, String value2) {
            addCriterion("relationship not between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("QQ is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("QQ is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("QQ =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("QQ <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("QQ >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("QQ >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("QQ <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("QQ <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("QQ like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("QQ not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("QQ in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("QQ not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("QQ between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("QQ not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        /**
         * 因为咨询人员查询的时候需要结合用户表，而用户表中也有telephone，所以需要增加一个前缀k
         *
         * @param value
         * @return
         */
        public Criteria andTelephoneEqualTo2(String value) {
            addCriterion("k.telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSystemIsNull() {
            addCriterion("system is null");
            return (Criteria) this;
        }

        public Criteria andSystemIsNotNull() {
            addCriterion("system is not null");
            return (Criteria) this;
        }

        public Criteria andSystemEqualTo(String value) {
            addCriterion("system =", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotEqualTo(String value) {
            addCriterion("system <>", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThan(String value) {
            addCriterion("system >", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThanOrEqualTo(String value) {
            addCriterion("system >=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThan(String value) {
            addCriterion("system <", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThanOrEqualTo(String value) {
            addCriterion("system <=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLike(String value) {
            addCriterion("system like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotLike(String value) {
            addCriterion("system not like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemIn(List<String> values) {
            addCriterion("system in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotIn(List<String> values) {
            addCriterion("system not in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemBetween(String value1, String value2) {
            addCriterion("system between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotBetween(String value1, String value2) {
            addCriterion("system not between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonIsNull() {
            addCriterion("consultationperson is null");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonIsNotNull() {
            addCriterion("consultationperson is not null");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonEqualTo(String value) {
            addCriterion("consultationperson =", value, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonNotEqualTo(String value) {
            addCriterion("consultationperson <>", value, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonGreaterThan(String value) {
            addCriterion("consultationperson >", value, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonGreaterThanOrEqualTo(String value) {
            addCriterion("consultationperson >=", value, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonLessThan(String value) {
            addCriterion("consultationperson <", value, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonLessThanOrEqualTo(String value) {
            addCriterion("consultationperson <=", value, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonLike(String value) {
            addCriterion("consultationperson like", value, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonNotLike(String value) {
            addCriterion("consultationperson not like", value, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonIn(List<String> values) {
            addCriterion("consultationperson in", values, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonNotIn(List<String> values) {
            addCriterion("consultationperson not in", values, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonBetween(String value1, String value2) {
            addCriterion("consultationperson between", value1, value2, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationpersonNotBetween(String value1, String value2) {
            addCriterion("consultationperson not between", value1, value2, "consultationperson");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeIsNull() {
            addCriterion("k.consultationtime is null");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeIsNotNull() {
            addCriterion("k.consultationtime is not null");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeEqualTo(Date value) {
            addCriterion("k.consultationtime =", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeNotEqualTo(Date value) {
            addCriterion("k.consultationtime <>", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeGreaterThan(Date value) {
            addCriterion("k.consultationtime >", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("k.consultationtime >=", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeLessThan(Date value) {
            addCriterion("k.consultationtime <", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeLessThanOrEqualTo(Date value) {
            addCriterion("k.consultationtime <=", value, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeIn(List<Date> values) {
            addCriterion("k.consultationtime in", values, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeNotIn(List<Date> values) {
            addCriterion("k.consultationtime not in", values, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeBetween(Date value1, Date value2) {
            addCriterion("k.consultationtime between", value1, value2, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeBetween(String value1, String value2) {
            addCriterion("DATE_FORMAT(k.consultationtime, '%Y-%m-%d') between", value1, value2, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtimeNotBetween(Date value1, Date value2) {
            addCriterion("k.consultationtime not between", value1, value2, "consultationtime");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessIsNull() {
            addCriterion("consultationprocess is null");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessIsNotNull() {
            addCriterion("consultationprocess is not null");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessEqualTo(String value) {
            addCriterion("consultationprocess =", value, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessNotEqualTo(String value) {
            addCriterion("consultationprocess <>", value, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessGreaterThan(String value) {
            addCriterion("consultationprocess >", value, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessGreaterThanOrEqualTo(String value) {
            addCriterion("consultationprocess >=", value, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessLessThan(String value) {
            addCriterion("consultationprocess <", value, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessLessThanOrEqualTo(String value) {
            addCriterion("consultationprocess <=", value, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessLike(String value) {
            addCriterion("consultationprocess like", value, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessNotLike(String value) {
            addCriterion("consultationprocess not like", value, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessIn(List<String> values) {
            addCriterion("consultationprocess in", values, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessNotIn(List<String> values) {
            addCriterion("consultationprocess not in", values, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessBetween(String value1, String value2) {
            addCriterion("consultationprocess between", value1, value2, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andConsultationprocessNotBetween(String value1, String value2) {
            addCriterion("consultationprocess not between", value1, value2, "consultationprocess");
            return (Criteria) this;
        }

        public Criteria andContactstateIsNull() {
            addCriterion("contactstate is null");
            return (Criteria) this;
        }

        public Criteria andContactstateIsNotNull() {
            addCriterion("contactstate is not null");
            return (Criteria) this;
        }

        public Criteria andContactstateEqualTo(String value) {
            addCriterion("contactstate =", value, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateNotEqualTo(String value) {
            addCriterion("contactstate <>", value, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateGreaterThan(String value) {
            addCriterion("contactstate >", value, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateGreaterThanOrEqualTo(String value) {
            addCriterion("contactstate >=", value, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateLessThan(String value) {
            addCriterion("contactstate <", value, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateLessThanOrEqualTo(String value) {
            addCriterion("contactstate <=", value, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateLike(String value) {
            addCriterion("contactstate like", value, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateNotLike(String value) {
            addCriterion("contactstate not like", value, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateIn(List<String> values) {
            addCriterion("contactstate in", values, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateNotIn(List<String> values) {
            addCriterion("contactstate not in", values, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateBetween(String value1, String value2) {
            addCriterion("contactstate between", value1, value2, "contactstate");
            return (Criteria) this;
        }

        public Criteria andContactstateNotBetween(String value1, String value2) {
            addCriterion("contactstate not between", value1, value2, "contactstate");
            return (Criteria) this;
        }

        public Criteria andRemindtimeIsNull() {
            addCriterion("k.remindtime is null");
            return (Criteria) this;
        }

        public Criteria andRemindtimeIsNotNull() {
            addCriterion("k.remindtime is not null");
            return (Criteria) this;
        }

        public Criteria andRemindtimeEqualTo(Date value) {
            addCriterion("k.remindtime =", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeNotEqualTo(Date value) {
            addCriterion("k.remindtime <>", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeGreaterThan(Date value) {
            addCriterion("k.remindtime >", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("k.remindtime >=", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeLessThan(Date value) {
            addCriterion("k.remindtime <", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeLessThanOrEqualTo(Date value) {
            addCriterion("( k.remindtime is null or k.remindtime <='" + value + "')");
            return (Criteria) this;
        }

        public Criteria andRemindtimeIn(List<Date> values) {
            addCriterion("k.remindtime in", values, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeNotIn(List<Date> values) {
            addCriterion("k.remindtime not in", values, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeBetween(Date value1, Date value2) {
            addCriterion("k.remindtime between", value1, value2, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeNotBetween(Date value1, Date value2) {
            addCriterion("k.remindtime not between", value1, value2, "remindtime");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeIsNull() {
            addCriterion("consultationtype is null");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeIsNotNull() {
            addCriterion("consultationtype is not null");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeEqualTo(String value) {
            addCriterion("consultationtype =", value, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeNotEqualTo(String value) {
            addCriterion("consultationtype <>", value, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeGreaterThan(String value) {
            addCriterion("consultationtype >", value, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeGreaterThanOrEqualTo(String value) {
            addCriterion("consultationtype >=", value, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeLessThan(String value) {
            addCriterion("consultationtype <", value, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeLessThanOrEqualTo(String value) {
            addCriterion("consultationtype <=", value, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeLike(String value) {
            addCriterion("consultationtype like", value, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeNotLike(String value) {
            addCriterion("consultationtype not like", value, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeIn(List<String> values) {
            addCriterion("consultationtype in", values, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeNotIn(List<String> values) {
            addCriterion("consultationtype not in", values, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeBetween(String value1, String value2) {
            addCriterion("consultationtype between", value1, value2, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andConsultationtypeNotBetween(String value1, String value2) {
            addCriterion("consultationtype not between", value1, value2, "consultationtype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeIsNull() {
            addCriterion("markettype is null");
            return (Criteria) this;
        }

        public Criteria andMarkettypeIsNotNull() {
            addCriterion("markettype is not null");
            return (Criteria) this;
        }

        public Criteria andMarkettypeEqualTo(String value) {
            addCriterion("markettype =", value, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeNotEqualTo(String value) {
            addCriterion("markettype <>", value, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeGreaterThan(String value) {
            addCriterion("markettype >", value, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeGreaterThanOrEqualTo(String value) {
            addCriterion("markettype >=", value, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeLessThan(String value) {
            addCriterion("markettype <", value, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeLessThanOrEqualTo(String value) {
            addCriterion("markettype <=", value, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeLike(String value) {
            addCriterion("markettype like", value, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeNotLike(String value) {
            addCriterion("markettype not like", value, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeIn(List<String> values) {
            addCriterion("markettype in", values, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeNotIn(List<String> values) {
            addCriterion("markettype not in", values, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeBetween(String value1, String value2) {
            addCriterion("markettype between", value1, value2, "markettype");
            return (Criteria) this;
        }

        public Criteria andMarkettypeNotBetween(String value1, String value2) {
            addCriterion("markettype not between", value1, value2, "markettype");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonIsNull() {
            addCriterion("keeponperson is null");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonIsNotNull() {
            addCriterion("keeponperson is not null");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonEqualTo(String value) {
            addCriterion("keeponperson =", value, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonNotEqualTo(String value) {
            addCriterion("keeponperson <>", value, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonGreaterThan(String value) {
            addCriterion("keeponperson >", value, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonGreaterThanOrEqualTo(String value) {
            addCriterion("keeponperson >=", value, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonLessThan(String value) {
            addCriterion("keeponperson <", value, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonLessThanOrEqualTo(String value) {
            addCriterion("keeponperson <=", value, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonLike(String value) {
            addCriterion("keeponperson like", value, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonNotLike(String value) {
            addCriterion("keeponperson not like", value, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonIn(List<String> values) {
            addCriterion("keeponperson in", values, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonNotIn(List<String> values) {
            addCriterion("keeponperson not in", values, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonBetween(String value1, String value2) {
            addCriterion("keeponperson between", value1, value2, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeeponpersonNotBetween(String value1, String value2) {
            addCriterion("keeponperson not between", value1, value2, "keeponperson");
            return (Criteria) this;
        }

        public Criteria andKeepontimeIsNull() {
            addCriterion("keepontime is null");
            return (Criteria) this;
        }

        public Criteria andKeepontimeIsNotNull() {
            addCriterion("keepontime is not null");
            return (Criteria) this;
        }

        public Criteria andKeepontimeEqualTo(Date value) {
            addCriterion("keepontime =", value, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeNotEqualTo(Date value) {
            addCriterion("keepontime <>", value, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeGreaterThan(Date value) {
            addCriterion("keepontime >", value, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeGreaterThanOrEqualTo(Date value) {
            addCriterion("keepontime >=", value, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeLessThan(Date value) {
            addCriterion("keepontime <", value, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeLessThanOrEqualTo(Date value) {
            addCriterion("keepontime <=", value, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeIn(List<Date> values) {
            addCriterion("keepontime in", values, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeNotIn(List<Date> values) {
            addCriterion("keepontime not in", values, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeBetween(Date value1, Date value2) {
            addCriterion("keepontime between", value1, value2, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeBetween(String value1, String value2) {
            addCriterion("DATE_FORMAT(keepontime, '%Y-%m-%d') between", value1, value2, "keepontime");
            return (Criteria) this;
        }

        public Criteria andKeepontimeNotBetween(Date value1, Date value2) {
            addCriterion("keepontime not between", value1, value2, "keepontime");
            return (Criteria) this;
        }

        public Criteria andVisitdateIsNull() {
            addCriterion("visitdate is null");
            return (Criteria) this;
        }

        public Criteria andVisitdateIsNotNull() {
            addCriterion("visitdate is not null");
            return (Criteria) this;
        }

        public Criteria andVisitdateEqualTo(Date value) {
            addCriterion("visitdate =", value, "visitdate");
            return (Criteria) this;
        }

        public Criteria andVisitdateNotEqualTo(Date value) {
            addCriterion("visitdate <>", value, "visitdate");
            return (Criteria) this;
        }

        public Criteria andVisitdateGreaterThan(Date value) {
            addCriterion("visitdate >", value, "visitdate");
            return (Criteria) this;
        }

        public Criteria andVisitdateGreaterThanOrEqualTo(Date value) {
            addCriterion("visitdate >=", value, "visitdate");
            return (Criteria) this;
        }

        public Criteria andVisitdateLessThan(Date value) {
            addCriterion("visitdate <", value, "visitdate");
            return (Criteria) this;
        }

        public Criteria andVisitdateLessThanOrEqualTo(Date value) {
            addCriterion("visitdate <=", value, "visitdate");
            return (Criteria) this;
        }

        public Criteria andVisitdateIn(List<Date> values) {
            addCriterion("visitdate in", values, "visitdate");
            return (Criteria) this;
        }

        public Criteria andVisitdateNotIn(List<Date> values) {
            addCriterion("visitdate not in", values, "visitdate");
            return (Criteria) this;
        }

        public Criteria andVisitdateBetween(Date value1, Date value2) {
            addCriterion("visitdate between", value1, value2, "visitdate");
            return (Criteria) this;
        }

        public Criteria andVisitdateNotBetween(Date value1, Date value2) {
            addCriterion("visitdate not between", value1, value2, "visitdate");
            return (Criteria) this;
        }

        public Criteria andDeletestatusIsNull() {
            addCriterion("deletestatus is null");
            return (Criteria) this;
        }

        public Criteria andDeletestatusIsNotNull() {
            addCriterion("deletestatus is not null");
            return (Criteria) this;
        }

        public Criteria andDeletestatusEqualTo(String value) {
            addCriterion("deletestatus =", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotEqualTo(String value) {
            addCriterion("deletestatus <>", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusGreaterThan(String value) {
            addCriterion("deletestatus >", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusGreaterThanOrEqualTo(String value) {
            addCriterion("deletestatus >=", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusLessThan(String value) {
            addCriterion("deletestatus <", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusLessThanOrEqualTo(String value) {
            addCriterion("deletestatus <=", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusLike(String value) {
            addCriterion("deletestatus like", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotLike(String value) {
            addCriterion("deletestatus not like", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusIn(List<String> values) {
            addCriterion("deletestatus in", values, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotIn(List<String> values) {
            addCriterion("deletestatus not in", values, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusBetween(String value1, String value2) {
            addCriterion("deletestatus between", value1, value2, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotBetween(String value1, String value2) {
            addCriterion("deletestatus not between", value1, value2, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusIsNull() {
            addCriterion("nowstatus is null");
            return (Criteria) this;
        }

        public Criteria andNowstatusIsNotNull() {
            addCriterion("nowstatus is not null");
            return (Criteria) this;
        }

        public Criteria andNowstatusEqualTo(String value) {
            addCriterion("nowstatus =", value, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusNotEqualTo(String value) {
            addCriterion("nowstatus <>", value, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusGreaterThan(String value) {
            addCriterion("nowstatus >", value, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusGreaterThanOrEqualTo(String value) {
            addCriterion("nowstatus >=", value, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusLessThan(String value) {
            addCriterion("nowstatus <", value, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusLessThanOrEqualTo(String value) {
            addCriterion("nowstatus <=", value, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusLike(String value) {
            addCriterion("nowstatus like", value, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusNotLike(String value) {
            addCriterion("nowstatus not like", value, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusIn(List<String> values) {
            addCriterion("nowstatus in", values, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusNotIn(List<String> values) {
            addCriterion("nowstatus not in", values, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusBetween(String value1, String value2) {
            addCriterion("nowstatus between", value1, value2, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andNowstatusNotBetween(String value1, String value2) {
            addCriterion("nowstatus not between", value1, value2, "nowstatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorIsNull() {
            addCriterion("supervisor is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorIsNotNull() {
            addCriterion("supervisor is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorEqualTo(String value) {
            addCriterion("supervisor =", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotEqualTo(String value) {
            addCriterion("supervisor <>", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorGreaterThan(String value) {
            addCriterion("supervisor >", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor >=", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLessThan(String value) {
            addCriterion("supervisor <", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLessThanOrEqualTo(String value) {
            addCriterion("supervisor <=", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLike(String value) {
            addCriterion("supervisor like", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotLike(String value) {
            addCriterion("supervisor not like", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorIn(List<String> values) {
            addCriterion("supervisor in", values, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotIn(List<String> values) {
            addCriterion("supervisor not in", values, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorBetween(String value1, String value2) {
            addCriterion("supervisor between", value1, value2, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotBetween(String value1, String value2) {
            addCriterion("supervisor not between", value1, value2, "supervisor");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeIsNull() {
            addCriterion("trainingtype is null");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeIsNotNull() {
            addCriterion("trainingtype is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeEqualTo(String value) {
            addCriterion("trainingtype =", value, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeNotEqualTo(String value) {
            addCriterion("trainingtype <>", value, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeGreaterThan(String value) {
            addCriterion("trainingtype >", value, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeGreaterThanOrEqualTo(String value) {
            addCriterion("trainingtype >=", value, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeLessThan(String value) {
            addCriterion("trainingtype <", value, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeLessThanOrEqualTo(String value) {
            addCriterion("trainingtype <=", value, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeLike(String value) {
            addCriterion("trainingtype like", value, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeNotLike(String value) {
            addCriterion("trainingtype not like", value, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeIn(List<String> values) {
            addCriterion("trainingtype in", values, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeNotIn(List<String> values) {
            addCriterion("trainingtype not in", values, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeBetween(String value1, String value2) {
            addCriterion("trainingtype between", value1, value2, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andTrainingtypeNotBetween(String value1, String value2) {
            addCriterion("trainingtype not between", value1, value2, "trainingtype");
            return (Criteria) this;
        }

        public Criteria andBookclassIsNull() {
            addCriterion("bookclass is null");
            return (Criteria) this;
        }

        public Criteria andBookclassIsNotNull() {
            addCriterion("bookclass is not null");
            return (Criteria) this;
        }

        public Criteria andBookclassEqualTo(String value) {
            addCriterion("bookclass =", value, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassNotEqualTo(String value) {
            addCriterion("bookclass <>", value, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassGreaterThan(String value) {
            addCriterion("bookclass >", value, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassGreaterThanOrEqualTo(String value) {
            addCriterion("bookclass >=", value, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassLessThan(String value) {
            addCriterion("bookclass <", value, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassLessThanOrEqualTo(String value) {
            addCriterion("bookclass <=", value, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassLike(String value) {
            addCriterion("bookclass like", value, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassNotLike(String value) {
            addCriterion("bookclass not like", value, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassIn(List<String> values) {
            addCriterion("bookclass in", values, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassNotIn(List<String> values) {
            addCriterion("bookclass not in", values, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassBetween(String value1, String value2) {
            addCriterion("bookclass between", value1, value2, "bookclass");
            return (Criteria) this;
        }

        public Criteria andBookclassNotBetween(String value1, String value2) {
            addCriterion("bookclass not between", value1, value2, "bookclass");
            return (Criteria) this;
        }

        public Criteria andSchoolareaIsNull() {
            addCriterion("schoolarea is null");
            return (Criteria) this;
        }

        public Criteria andSchoolareaIsNotNull() {
            addCriterion("schoolarea is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolareaEqualTo(String value) {
            addCriterion("schoolarea =", value, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaNotEqualTo(String value) {
            addCriterion("schoolarea <>", value, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaGreaterThan(String value) {
            addCriterion("schoolarea >", value, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaGreaterThanOrEqualTo(String value) {
            addCriterion("schoolarea >=", value, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaLessThan(String value) {
            addCriterion("schoolarea <", value, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaLessThanOrEqualTo(String value) {
            addCriterion("schoolarea <=", value, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaLike(String value) {
            addCriterion("schoolarea like", value, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaNotLike(String value) {
            addCriterion("schoolarea not like", value, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaIn(List<String> values) {
            addCriterion("schoolarea in", values, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaNotIn(List<String> values) {
            addCriterion("schoolarea not in", values, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaBetween(String value1, String value2) {
            addCriterion("schoolarea between", value1, value2, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andSchoolareaNotBetween(String value1, String value2) {
            addCriterion("schoolarea not between", value1, value2, "schoolarea");
            return (Criteria) this;
        }

        public Criteria andBooktimeIsNull() {
            addCriterion("booktime is null");
            return (Criteria) this;
        }

        public Criteria andBooktimeIsNotNull() {
            addCriterion("booktime is not null");
            return (Criteria) this;
        }

        public Criteria andBooktimeEqualTo(Date value) {
            addCriterion("booktime =", value, "booktime");
            return (Criteria) this;
        }

        public Criteria andBooktimeNotEqualTo(Date value) {
            addCriterion("booktime <>", value, "booktime");
            return (Criteria) this;
        }

        public Criteria andBooktimeGreaterThan(Date value) {
            addCriterion("booktime >", value, "booktime");
            return (Criteria) this;
        }

        public Criteria andBooktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("booktime >=", value, "booktime");
            return (Criteria) this;
        }

        public Criteria andBooktimeLessThan(Date value) {
            addCriterion("booktime <", value, "booktime");
            return (Criteria) this;
        }

        public Criteria andBooktimeLessThanOrEqualTo(Date value) {
            addCriterion("booktime <=", value, "booktime");
            return (Criteria) this;
        }

        public Criteria andBooktimeIn(List<Date> values) {
            addCriterion("booktime in", values, "booktime");
            return (Criteria) this;
        }

        public Criteria andBooktimeNotIn(List<Date> values) {
            addCriterion("booktime not in", values, "booktime");
            return (Criteria) this;
        }

        public Criteria andBooktimeBetween(Date value1, Date value2) {
            addCriterion("booktime between", value1, value2, "booktime");
            return (Criteria) this;
        }

        public Criteria andBooktimeNotBetween(Date value1, Date value2) {
            addCriterion("booktime not between", value1, value2, "booktime");
            return (Criteria) this;
        }

        public Criteria andVisiteddateIsNull() {
            addCriterion("visiteddate is null");
            return (Criteria) this;
        }

        public Criteria andVisiteddateIsNotNull() {
            addCriterion("visiteddate is not null");
            return (Criteria) this;
        }

        public Criteria andVisiteddateEqualTo(Date value) {
            addCriterion("visiteddate =", value, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisiteddateNotEqualTo(Date value) {
            addCriterion("visiteddate <>", value, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisiteddateGreaterThan(Date value) {
            addCriterion("visiteddate >", value, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisiteddateGreaterThanOrEqualTo(Date value) {
            addCriterion("visiteddate >=", value, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisiteddateLessThan(Date value) {
            addCriterion("visiteddate <", value, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisiteddateLessThanOrEqualTo(Date value) {
            addCriterion("visiteddate <=", value, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisiteddateIn(List<Date> values) {
            addCriterion("visiteddate in", values, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisiteddateNotIn(List<Date> values) {
            addCriterion("visiteddate not in", values, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisiteddateBetween(Date value1, Date value2) {
            addCriterion("visiteddate between", value1, value2, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisiteddateNotBetween(Date value1, Date value2) {
            addCriterion("visiteddate not between", value1, value2, "visiteddate");
            return (Criteria) this;
        }

        public Criteria andVisitdescIsNull() {
            addCriterion("visitdesc is null");
            return (Criteria) this;
        }

        public Criteria andVisitdescIsNotNull() {
            addCriterion("visitdesc is not null");
            return (Criteria) this;
        }

        public Criteria andVisitdescEqualTo(String value) {
            addCriterion("visitdesc =", value, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescNotEqualTo(String value) {
            addCriterion("visitdesc <>", value, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescGreaterThan(String value) {
            addCriterion("visitdesc >", value, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescGreaterThanOrEqualTo(String value) {
            addCriterion("visitdesc >=", value, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescLessThan(String value) {
            addCriterion("visitdesc <", value, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescLessThanOrEqualTo(String value) {
            addCriterion("visitdesc <=", value, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescLike(String value) {
            addCriterion("visitdesc like", value, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescNotLike(String value) {
            addCriterion("visitdesc not like", value, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescIn(List<String> values) {
            addCriterion("visitdesc in", values, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescNotIn(List<String> values) {
            addCriterion("visitdesc not in", values, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescBetween(String value1, String value2) {
            addCriterion("visitdesc between", value1, value2, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andVisitdescNotBetween(String value1, String value2) {
            addCriterion("visitdesc not between", value1, value2, "visitdesc");
            return (Criteria) this;
        }

        public Criteria andShifttimeIsNull() {
            addCriterion("shifttime is null");
            return (Criteria) this;
        }

        public Criteria andShifttimeIsNotNull() {
            addCriterion("shifttime is not null");
            return (Criteria) this;
        }

        public Criteria andShifttimeEqualTo(Date value) {
            addCriterion("shifttime =", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeNotEqualTo(Date value) {
            addCriterion("shifttime <>", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeGreaterThan(Date value) {
            addCriterion("shifttime >", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shifttime >=", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeLessThan(Date value) {
            addCriterion("shifttime <", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeLessThanOrEqualTo(Date value) {
            addCriterion("shifttime <=", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeIn(List<Date> values) {
            addCriterion("shifttime in", values, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeNotIn(List<Date> values) {
            addCriterion("shifttime not in", values, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeBetween(Date value1, Date value2) {
            addCriterion("shifttime between", value1, value2, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeNotBetween(Date value1, Date value2) {
            addCriterion("shifttime not between", value1, value2, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShiftclassIsNull() {
            addCriterion("shiftclass is null");
            return (Criteria) this;
        }

        public Criteria andShiftclassIsNotNull() {
            addCriterion("shiftclass is not null");
            return (Criteria) this;
        }

        public Criteria andShiftclassEqualTo(String value) {
            addCriterion("shiftclass =", value, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassNotEqualTo(String value) {
            addCriterion("shiftclass <>", value, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassGreaterThan(String value) {
            addCriterion("shiftclass >", value, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassGreaterThanOrEqualTo(String value) {
            addCriterion("shiftclass >=", value, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassLessThan(String value) {
            addCriterion("shiftclass <", value, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassLessThanOrEqualTo(String value) {
            addCriterion("shiftclass <=", value, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassLike(String value) {
            addCriterion("shiftclass like", value, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassNotLike(String value) {
            addCriterion("shiftclass not like", value, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassIn(List<String> values) {
            addCriterion("shiftclass in", values, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassNotIn(List<String> values) {
            addCriterion("shiftclass not in", values, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassBetween(String value1, String value2) {
            addCriterion("shiftclass between", value1, value2, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andShiftclassNotBetween(String value1, String value2) {
            addCriterion("shiftclass not between", value1, value2, "shiftclass");
            return (Criteria) this;
        }

        public Criteria andPaymoneyIsNull() {
            addCriterion("paymoney is null");
            return (Criteria) this;
        }

        public Criteria andPaymoneyIsNotNull() {
            addCriterion("paymoney is not null");
            return (Criteria) this;
        }

        public Criteria andPaymoneyEqualTo(Float value) {
            addCriterion("paymoney =", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyNotEqualTo(Float value) {
            addCriterion("paymoney <>", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyGreaterThan(Float value) {
            addCriterion("paymoney >", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("paymoney >=", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyLessThan(Float value) {
            addCriterion("paymoney <", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyLessThanOrEqualTo(Float value) {
            addCriterion("paymoney <=", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyIn(List<Float> values) {
            addCriterion("paymoney in", values, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyNotIn(List<Float> values) {
            addCriterion("paymoney not in", values, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyBetween(Float value1, Float value2) {
            addCriterion("paymoney between", value1, value2, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyNotBetween(Float value1, Float value2) {
            addCriterion("paymoney not between", value1, value2, "paymoney");
            return (Criteria) this;
        }

        public Criteria andHeadmasterIsNull() {
            addCriterion("headmaster is null");
            return (Criteria) this;
        }

        public Criteria andHeadmasterIsNotNull() {
            addCriterion("headmaster is not null");
            return (Criteria) this;
        }

        public Criteria andHeadmasterEqualTo(String value) {
            addCriterion("headmaster =", value, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterNotEqualTo(String value) {
            addCriterion("headmaster <>", value, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterGreaterThan(String value) {
            addCriterion("headmaster >", value, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterGreaterThanOrEqualTo(String value) {
            addCriterion("headmaster >=", value, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterLessThan(String value) {
            addCriterion("headmaster <", value, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterLessThanOrEqualTo(String value) {
            addCriterion("headmaster <=", value, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterLike(String value) {
            addCriterion("headmaster like", value, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterNotLike(String value) {
            addCriterion("headmaster not like", value, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterIn(List<String> values) {
            addCriterion("headmaster in", values, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterNotIn(List<String> values) {
            addCriterion("headmaster not in", values, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterBetween(String value1, String value2) {
            addCriterion("headmaster between", value1, value2, "headmaster");
            return (Criteria) this;
        }

        public Criteria andHeadmasterNotBetween(String value1, String value2) {
            addCriterion("headmaster not between", value1, value2, "headmaster");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer uid) {
            addCriterion("u.id =", uid, "uid");
            return (Criteria) this;
        }

        public Criteria andRolecodeEqualTo(String value) {
            addCriterion("rolecode =", value, "rolecode");
            return (Criteria) this;
        }

        /**
         * 最后咨询时间小于等于提醒时间或者咨询时间为空
         *
         * @return
         */
        public Criteria andConsultationtimeLessThanOrEqualToRemindtime() {
            addCriterion("( k.consultationtime is null or  k.consultationtime <= k.remindtime )");
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