<%@ include  file="common/header.jspf" %>
<body>
<%@ include  file="common/navigation.jspf" %>
<div class="container">
    <h1>Enter todo pages</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset>
            <form:label path="description" >Description :</form:label>
            <form:input type="text" name="description" placeholder="Enter description" path="description"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset>
            <form:label path="targetDate" >Target Date :</form:label>
            <form:input type="text" path="targetDate"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="done"/>
        <input type="submit" class="btn btn-success" />
    </form:form>
</div>
</body>
<%@include file="common/footer.jspf"%>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    })
</script>
</html>