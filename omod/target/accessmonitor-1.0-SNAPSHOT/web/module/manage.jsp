<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>

<span class="boxHeader">Current Person Access Tables</span>
<div class="box">

    <table id="oldtables1" class="display" cellspacing="0" width="100%">
        <tr>
            <th>Person Access Id</th>
            <th>Accessor Id</th>
            <th>Person Id</th>
            <th>Person Type</th>
            <th>Access Type</th>
            <th>Person Uuid</th>
            <th>Void Reason</th>
            <th>Access Date</th>
        </tr>
        <c:forEach var="table" items="${tables1}">
            <tr>
                <td>${table.personAccessId}</td>
                <td>${table.accessorId}</td>
                <td>${table.personId}</td>
                <td>${table.personType}</td>
                <td>${table.accessType}</td>
                <td>${table.personUuid}</td>
                <td>${table.voidReason}</td>
                <td>${table.accessDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<span class="boxHeader">Current Order Access Tables</span>
<div class="box">

    <table id="oldtables2" class="display" cellspacing="0" width="100%">
        <tr>
            <th>Order Access Id</th>
            <th>Accessor Id</th>
            <th>Order Id</th>
            <th>Patient Id</th>
            <th>User Id</th>
            <th>Order Type</th>
            <th>Access Type</th>
            <th>Order Uuid</th>
            <th>Access Date</th>
        </tr>
        <c:forEach var="table" items="${tables2}">
            <tr>
                <td>${table.orderAccessId}</td>
                <td>${table.accessorId}</td>
                <td>${table.orderId}</td>
                <td>${table.patientId}</td>
                <td>${table.userId}</td>
                <td>${table.orderType}</td>
                <td>${table.accessType}</td>
                <td>${table.orderUuid}</td>
                <td>${table.accessDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<span class="boxHeader">Current Visit Access Tables</span>
<div class="box">

    <table id="oldtables3" class="display" cellspacing="0" width="100%">
        <tr>
            <th>Visit Access Id</th>
            <th>Accessor Id</th>
            <th>Visit Id</th>
            <th>Patient Id</th>
            <th>Visit Type</th>
            <th>Access Type</th>
            <th>Visit Uuid</th>
            <th>Void Reason</th>
            <th>Visit Start Date</th>
            <th>Visit End Date</th>
            <th>Access Date</th>
        </tr>
        <c:forEach var="table" items="${tables3}">
            <tr>
                <td>${table.visitAccessId}</td>
                <td>${table.accessorId}</td>
                <td>${table.visitId}</td>
                <td>${table.patientId}</td>
                <td>${table.visitType}</td>
                <td>${table.accessType}</td>
                <td>${table.visitUuid}</td>
                <td>${table.voidReason}</td>
                <td>${table.visitStartDate}</td>
                <td>${table.visitEndDate}</td>
                <td>${table.accessDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>