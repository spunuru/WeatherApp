/**
 * This class is the main view for the application. It is specified in app.js as the
 * "autoCreateViewport" property. That setting automatically applies the "viewport"
 * plugin to promote that instance of this class to the body element.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('WeatherApp.view.main.Main', {
    extend: 'Ext.container.Container',
	requires: [
	        'Ext.grid.*',
	        'Ext.data.*',
	        'WeatherApp.model.ForcastForADay'
	    ],
    xtype: 'app-main',
    
    controller: 'main',
    viewModel: {
        type: 'main'
    },

    layout: {
        type: 'fit'
    },
	initComponent: function() {
		var me = this;
		
		// The data store containing the list of states
		var states = Ext.create('Ext.data.Store', {
		    fields: ['abbr', 'name'],
		    data : [
		        {"value":"Washington,DC,USA", "name":"Washington DC"},
		        {"value":"Baltimore,MD,USA", "name":"Baltimore"},
		        {"value":"New York,NY,USA", "name":"New York"}
		    ]
		});

		// Create the combo box, attached to the states data store
		var cityDropdown = Ext.create('Ext.form.ComboBox', {
		    fieldLabel: 'Select a city to check weather ',
		    store: states,
		    queryMode: 'local',
		    displayField: 'name',
		    valueField: 'value',
			itemId: 'cityDropdown',
		    //renderTo: Ext.getBody(),
			listeners: {
				scope: this,
			    'select': this.cityChanged
			}
		});
		
        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
			        bind: {
			            title: '{name}'
			        },					
                    itemId: 'mainWindow',
                    bodyPadding: 0,
                    icon: '',
                    title: '',
                    dockedItems: [],
					tbar: [
						cityDropdown
					],
					items: [
						{
	                    	xtype: 'gridpanel',
		                    itemId: 'forecastGrid',
		                    padding: 10,
							store: new Ext.data.Store({
								// destroy the store if the grid is destroyed
								autoDestroy: true,
								model: WeatherApp.model.ForcastForADay,
								proxy: {
									type: 'ajax',
									// load remote data using HTTP
									url: 'weather',
									reader: {
										type: 'json',
										rootProperty: 'list'
									}
								},
							}),
		                    columns: [
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'date',
		                            text: 'Date',
		                            flex: 1
		                        },		                    
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'weather',
		                            text: 'Icon',
		                            flex: 1,
								    renderer: function(value) {
								   		return '<img src="http://openweathermap.org/img/w/' + value[0].icon + '.png" />';
								    }
									
		                        },		                    
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'tempDay',
		                            text: 'Day Temp (F)',
		                            flex: 1
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'tempMin',
		                            text: 'Min Temp (F)',
		                            flex: 1
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'tempMax',
		                            text: 'Max Temp (F)',
		                            flex: 1
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'tempNight',
		                            text: 'Temp Night (F)',
		                            flex: 1
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'tempEve',
		                            text: 'Temp Evening (F)',
		                            flex: 1
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'tempMorn',
		                            text: 'Temp Morning (F)',
		                            flex: 1
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'humidity',
		                            text: 'Humidity',
		                            flex: 1
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'weather',
		                            text: 'Short Desc',
		                            flex: 1,
								    renderer: function(value) {
								    	return value[0].main;
								    }
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'weather',
		                            text: 'Desc',
		                            flex: 1,
								    renderer: function(value) {
								    	return value[0].description;
								    }
									
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'speed',
		                            text: 'Wind Speed',
		                            flex: 1
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'deg',
		                            text: 'Degree',
		                            flex: 1
		                        },
		                        {
		                            xtype: 'gridcolumn',
		                            dataIndex: 'clouds',
		                            text: 'Clouds',
		                            flex: 1
		                        },

		                    ]								
																		
						}									
					]						
                }
            ]
        });
		
        me.callParent(arguments);
	},
	cityChanged: function() {
				
        var view = Ext.ComponentQuery.query('#forecastGrid')[0].getView(),
        	store = view.getStore(),
            cityValue = Ext.ComponentQuery.query("#cityDropdown")[0].getValue();
			
		store.load({
			params: {
				city: cityValue
			 }			
		});
		
	}
});
