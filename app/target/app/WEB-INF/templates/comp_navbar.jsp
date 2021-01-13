<div id="container_navbar" class="navbar bn-5">
    <div id="info_page" class="">
        <img class="mini-img rb-10" src="${pageContext.request.contextPath}/img/logo-ifsp.png" style="margin: 2px;">
        <h1 id="titulo_blog" class="font-regular tn-4 tpo" style="margin: 2px;">Blog</h1>
    </div>
    <div id="menu_buttons" class="">
        <a id="btn_conta" class="btn-is bn-1 tooltip-bot menu-bot" style="margin: 2px;">
            <span class="bn-6">
                <h6 class="font-bold tn-1">New</h6>
            </span>
            <i class="fas fa-plus tpo medium"></i>
        </a>
        <a class="btn-is bn-1 tooltip-bot" style="margin: 2px;" href="/app/logout.blog">
            <span class="bn-6">
                <h6 class="font-bold tn-1">Exit</h6>
            </span>
            <i class="fas fa-sign-out-alt tn-4 medium"></i>
        </a>
    </div>
</div>
<div id="conta_lista" class="menu-display bn-5" hidden>
    <form action="/app/new.post.blog" method="get">
        <fieldset style="border-radius: 5px;">
            <legend class="font-medium tpo"> New Post </legend>
            <textarea name="postagem" id="" cols="30" rows="10" style="resize: none;"></textarea>
            <input type="text" name="id_usuario" value="${id}" hidden>
            <br>
            <button class="btn-t bpo" type="submit" >
                <h4 class="font-regular tn-4">Publicar</h4>
            </button>
        </fieldset>
    </form>
</div>