Ext.define('WeatherApp.model.ForcastForADay', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    idProperty: 'date',

    fields: [
        {
            name: 'date',
            mapping: 'dtAsString'
        },
		{
			name: 'weather',
			mapping: 'weather'
		},		
        {
            name: 'tempDay',
            mapping: 'temp.day'			
        },
        {
            name: 'tempMin',
            mapping: 'temp.min'
        },
        {
            name: 'tempMax',
            mapping: 'temp.max'
        },
        {
            name: 'tempNight',
            mapping: 'temp.night'
        },		
        {
            name: 'tempEve',
            mapping: 'temp.eve'
        },
        {
            name: 'tempMorn',
            mapping: 'temp.morn'
        },
        {
            name: 'humidity',
            mapping: 'humidity'
        },
        {
            name: 'pressure',
            mapping: 'pressure'
        },
        {
            name: 'speed',
            mapping: 'speed'
        },		
		{
            name: 'deg',
            mapping: 'deg'
        },
        {
            name: 'clouds',
            mapping: 'clouds'
        }
    ]
});