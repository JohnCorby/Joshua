/**
 * handles scoping of variables
 *
 * this should be pretty easy
 * store scope LEVEL (number) in variable/as map
 * and change the level appropriately when entering/exiting scopes
 * then we can easily find variables at higher scopes by simply decreasing the level and trying to find it
 * OR
 * store scope level as STRING in map/vars
 * change when needed
 * find levels at higher scopes by just memorizing previous ones or something
 * nah this idea doesnt sound as good
 */
package com.johncorby.joshua.symbol

