<#import "/spring.ftl" as spring/>
<#import "/template.ftl" as c/>
<@c.page title="Admin">
<!-- custom page content -->
    <#include "/owner/owner_sidebar.ftl">

<div class="plaisio container-fluid">
    <div class="header_table_custom">
        <div class="boardmsg">
            <h4> Your vehicles </h4>
        </div>
    </div>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

    <#if errorMessage?has_content>
        <div class="boardmsg" id="boardmsg">
            <h2> ${errorMessage}</h2>
        </div>
    <#else>

        <div class="content-wrapper">
            <div class="container-fluid">
                <div class="card mb-3">
                    <div class="card-header">

                        <#if vehiclesList??>
                        <div class="col-md-12">
                            <div class="table-responsive" style="background: gainsboro">

                                <table id="mytable" class="table table-striped">
                                    <thead style="background-image: linear-gradient(to top,#f1f1f1,#fff);">
                                    <th style="display: none;">Id</th>
                                    <th>Plate</th>
                                    <th>Brand</th>
                                    <th>Color</th>
                                    </thead>
                                    <tbody>
                                        <#list vehiclesList as vehicle>
                                        <tr>
                                            <td class="id goToRepairs" style="display: none;">${vehicle.id}</td>
                                            <td class="plate goToRepairs">${vehicle.plate}</td>
                                            <td class="brand goToRepairs">${vehicle.brand}</td>
                                            <td class="color goToRepairs">${vehicle.color}</td>
                                        </tr>
                                        </#list>
                                    </tbody>

                                </table>
                            </div>

                        <#else>
                            <h2> No Vehicles have found!</h2>
                        </#if>
                    </div>
                    </div>
                </div>
            </div>
        </div>

    </#if>

</div>

<!--scripts loaded here-->

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script src="<@spring.url '/js/scripts.js'/>"></script>

</@c.page>

