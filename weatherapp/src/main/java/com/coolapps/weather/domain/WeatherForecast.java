package com.coolapps.weather.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {
	
    private static final int MILLISECONDS_IN_SECOND = 1000;

	private long cod;

	private City city;
	
	private java.util.List<com.coolapps.weather.domain.WeatherForecast.List> list;
    	
	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public java.util.List<com.coolapps.weather.domain.WeatherForecast.List> getList() {
		return list;
	}

	public void setList(
			java.util.List<com.coolapps.weather.domain.WeatherForecast.List> list) {
		this.list = list;
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class City {
		private long id;
		private String name;
		private String country;
		private long population;
		private Coord coord;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public long getPopulation() {
			return population;
		}

		public void setPopulation(long population) {
			this.population = population;
		}

		public Coord getCoord() {
			return coord;
		}

		public void setCoord(Coord coord) {
			this.coord = coord;
		}

		private static class Coord {
			private double lon;
			private double lat;

			public double getLon() {
				return lon;
			}
			public void setLon(double lon) {
				this.lon = lon;
			}
			public double getLat() {
				return lat;
			}
			public void setLat(double lat) {
				this.lat = lat;
			}
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class List {

	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EDT")
		private Date dtAsString;
		
		private long dt;
		
		private Temp temp;
		
		private Float pressure;
		
		private Float humidity;
		
		private java.util.List<Weather> weather;
		
		private Float speed;
		
		private int degree;
		
		private Float clouds;
						
		public Float getSpeed() {
			return speed;
		}

		public void setSpeed(Float speed) {
			this.speed = speed;
		}

		public int getDegree() {
			return degree;
		}

		public void setDegree(int degree) {
			this.degree = degree;
		}

		public Float getClouds() {
			return clouds;
		}

		public void setClouds(Float clouds) {
			this.clouds = clouds;
		}

		public Date getDtAsString() {
			return dtAsString;
		}

		public long getDt() {
			return dt;
		}


		public void setDt(long dt) {
			this.dt = dt;
			this.dtAsString = new Date(dt*MILLISECONDS_IN_SECOND);
		}


		public Temp getTemp() {
			return temp;
		}


		public void setTemp(Temp temp) {
			this.temp = temp;
		}


		public Float getPressure() {
			return pressure;
		}


		public void setPressure(Float pressure) {
			this.pressure = pressure;
		}


		public Float getHumidity() {
			return humidity;
		}


		public void setHumidity(Float humidity) {
			this.humidity = humidity;
		}

		public java.util.List<Weather> getWeather() {
			return weather;
		}

		public void setWeather(java.util.List<Weather> weather) {
			this.weather = weather;
		}


		@JsonIgnoreProperties(ignoreUnknown = true)
		private static class Weather {
			
			private long id;
			
			private String main;
			
			private String description;
			
			private String icon;

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getMain() {
				return main;
			}

			public void setMain(String main) {
				this.main = main;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public String getIcon() {
				return icon;
			}

			public void setIcon(String icon) {
				this.icon = icon;
			}
		}
		
		@JsonIgnoreProperties(ignoreUnknown = true)
		private static class Temp {		
			private Float day;
			private Float min;
			private Float max;
			private Float night;
			private Float eve;
			private Float morn;
			public Float getDay() {
				return day;
			}
			public void setDay(Float day) {
				this.day = day;
			}
			public Float getMin() {
				return min;
			}
			public void setMin(Float min) {
				this.min = min;
			}
			public Float getMax() {
				return max;
			}
			public void setMax(Float max) {
				this.max = max;
			}
			public Float getNight() {
				return night;
			}
			public void setNight(Float night) {
				this.night = night;
			}
			public Float getEve() {
				return eve;
			}
			public void setEve(Float eve) {
				this.eve = eve;
			}
			public Float getMorn() {
				return morn;
			}
			public void setMorn(Float morn) {
				this.morn = morn;
			}
		}
		
	}

}
