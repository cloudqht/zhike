<html>
<body>
<pre>

    User: ${user.name}
    ${user.getDescription()}
    colors: ${colors?size}
     <#--    遍历list-->
    <#list colors as x>
    This is color ${x_index}: ${x}
    </#list>
    <#--    遍历map-->
    <#list map?keys as key>
        Number: ${key}, Value:${map[key]}
    </#list>

    <#assign title="nowcoder">
    Title: ${title}
    <#include "header.ftl" parse=false>
</pre>
</body>

</html>