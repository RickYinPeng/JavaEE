	//使用AJAX加载数据字典，生成select方法
	//参数一：数据字典类型（dict_type_code）
	//参数二：将下拉选放入标签id
	//参数三：生成下拉选时，select标签的name属性值
	//参数四：需要回显时，选中哪个option
	function loadSelect(typecode,positonId,selectname,selectedId){
		//1.创建select对象，将name属性指定
		var $select =  $("<select name="+selectname+" ></select>");
		
		//2.添加提示选项
		
		$select.append($("<option value='' >---请选择---</option>"));
		
		//3.使用jQuery的ajax方法，访问后台Action
		$.post("${pageContext.request.contextPath}/BaseDictAction", { dict_type_code: typecode},
	  			function(data){
		//4.返回json数组对象，对其进行遍历
			//每次遍历创建一个option对象，
					$.each( data, function(i, json){
						
						var $option=$("<option value='"+json['dict_id']+"'>"+json["dict_item_name"]+"</option>")
					//判断是否需要回显，如果需要使其被选中
						if(json['dict_id']==selectedId){
							$option.attr("selected","selected")
						} 
					//添加到select对象中
						$select.append($option);
					
					});
						   				 	 
	  			},"json");
		

			
		//5.将组装好的select对象放入页面指定的位置
		$("#"+positonId).append($select);
	
	}