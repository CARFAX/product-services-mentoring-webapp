module("Dashboard", {
    setup: function() {
    	resetDashboardHtml();
    	this.dashboard = new Dashboard();
        this.server = sinon.fakeServer.create();
    },
	teardown: function () {
		this.server.restore();
	}
});

test("some test name", function(){
	ok(true);
});

function resetDashboardHtml() {
	if ($("#qunit-fixture").length === 0) {
		$("body").append('<div id="qunit-fixture">test markup, will be hidden</div>');
	}
	
	var html = '';
	
	$("#qunit-fixture").append(html);
}