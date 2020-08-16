<select name='fruits' size='30'>
    <option value='' selected>-- 선택 --</option>
	<#list message as kor>
	
    <option value='${kor}'>${kor}</option>
    
    </#list>
</select>