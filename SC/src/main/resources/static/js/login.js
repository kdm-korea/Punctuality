var login = {
		init : function() {
			var _this = this;
			$('#btn-login').on('click', function() {
				_this.save();
			});
		},
		save : function() {
			var data = {
					studentNum: $('#loginStudentNum').val()
			};
			$.ajax({
				type: 'POST',
				url: '/login',
				dataType: 'json',
				contentType:'application/json; charset=utf-8',
				data: JSON.stringify(data)
			}).done(function(){
				alert('글이 등록되었습니다.');
				//location.reload();
			}).fail(function (error){
				alert('error');
			});
		}
};

login.init();