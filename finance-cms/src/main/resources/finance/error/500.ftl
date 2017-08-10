<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="cn">
<head>
<#include "../commons/top.ftl" />
</head>
<body class="content-wrapper-body">
<#--内容区域开始-->
<section class="content-header">
    <h1>
        500 Error Page
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Examples</a></li>
        <li class="active">500 error</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="error-page">
        <h2 class="headline text-red">500</h2>

        <div class="error-content">
            <h3><i class="fa fa-warning text-red"></i> Oops! Something went wrong.</h3>

            <p>
                We will work on fixing that right away.
                Meanwhile, you may <a href="${base}/">return to dashboard</a> or try using the search form.
            </p>

            <form class="search-form">
                <div class="input-group">
                    <input type="text" name="search" class="form-control" placeholder="Search">

                    <div class="input-group-btn">
                        <button type="submit" name="submit" class="btn btn-danger btn-flat"><i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <!-- /.input-group -->
            </form>
        </div>
    </div>
    <!-- /.error-page -->
<#--内容区域结束-->
<#include "../commons/bottom.ftl" />
<script type="text/javascript">

</script>
</body>
</html>
