<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>맛좀볼래?</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="../resources/css/intro.css">
    <link rel="stylesheet" href="../resources/css/headerStyle.css">
    <link rel="stylesheet" href="../resources/css/userprofile.css">
    <link rel="stylesheet" href="../resources/css/footerStyle.css">
</head>
<body>

    <div class="title">
        <h1>
            오늘 무엇을 먹을지 고민하는 여러분을 위해
            <form action="">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="맛집 정보를 입력하세요" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">맛좀볼래?</button>
                </div>
            </form>
        </h1>
    </div>

<%@ include file="../views/common/header.jsp"%>
<%@ include file="../views/common/footer.jsp"%>  
</body>
</html> 