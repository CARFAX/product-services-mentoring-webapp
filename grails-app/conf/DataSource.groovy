dataSource {
	driverClassName = "org.h2.Driver"
	pooled = true


}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
        	  dbCreate = "create-drop"
			url = "jdbc:h2:mem:devDb;MVCC=TRUE"

		}
    }
    test {
        dataSource {
            dbCreate = "update"
           url = "jdbc:h2:mem:devDb;MVCC=TRUE"
        }
    }
    production {
        dataSource {
			pooled=false
			dbCreate = ""

        }
 		hibernate {
			default_schema='TEST_ADMIN'
		}
   }
}
