/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.sequenceiq.mock.swagger.v40.api;

import com.sequenceiq.mock.swagger.model.ApiAuditList;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-26T08:00:53.907+01:00")

@Api(value = "AuditsResource", description = "the AuditsResource API")
@RequestMapping(value = "/api/v40")
public interface AuditsResourceApi {

    Logger log = LoggerFactory.getLogger(AuditsResourceApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Fetch audit events from Cloudera Manager (CM) and CM managed services like HDFS, HBase, Impala, Hive, and Sentry.", nickname = "readAudits", notes = "Fetch audit events from Cloudera Manager (CM) and CM managed services like HDFS, HBase, Impala, Hive, and Sentry. <p> By default, this call will fetch the first 100 audit events (sorted from most recent to oldest) corresponding to a 1 day window based on provided end time (which defaults to the  current CM server time). The <em>startTime</em> and <em>endTime</em> parameters can be used to control the window being queried. <p> Audit events for CM managed services are only retrieved if Cloudera Navigator server is running.", response = ApiAuditList.class, authorizations = {
        @Authorization(value = "basic")
    }, tags={ "AuditsResource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ApiAuditList.class) })
    @RequestMapping(value = "/audits",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ApiAuditList> readAudits(@ApiParam(value = "End of the period to query in ISO 8601 format (defaults to current time).", defaultValue = "now") @Valid @RequestParam(value = "endTime", required = false, defaultValue="now") String endTime,@ApiParam(value = "Maximum number of audits to return", defaultValue = "100") @Valid @RequestParam(value = "maxResults", required = false, defaultValue="100") Integer maxResults,@ApiParam(value = "The query to filter out audits in the system. It accepts querying the intersection of a list of constraints, joined together with semicolons (without spaces). For example: </p> <dl> <dt>command==listStatus</dt> <dd>looks for audits with listStatus command.</dd> <dt>command==listStatus;username!=foo</dt> <dd>looks for audits with listStatus command but excludes audits generated by foo username</dd> <dt>command==listStatus;source==*oozie*</dt> <dd>looks for audits with listStatus command and source that contains the string 'oozie'. </dd> </dl>  Following are valid selectors for the query (if applicable to the audit): <table> <tr> <th> Selector </th> <th> Description </th> <th> SCM </th> <th> HDFS </th> <th> HBase </th> <th> Hive </th> <th> Impala </th> <th> Sentry </th> </tr> <tr> <td> service </td> <td> Cloudera Manager Service </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> </tr> <tr> <td> operation </td> <td> Operation name </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> </tr> <tr> <td> username </td> <td> User name </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> </tr> <tr> <td> impersonator</td> <td> Impersonator </td> <td> </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> </tr> <tr> <td> ip_address </td> <td> IP Address </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> </tr> <tr> <td> allowed </td> <td> Whether the request was allowed or denied </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> </tr> <tr> <td> qualifier</td> <td> Column qualifier </td> <td> </td> <td> </td> <td> x </td> <td> </td> <td> </td> <td> </td> </tr> <tr> <td> source </td> <td> Source resource of the operation  </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> </td> </tr> <tr> <td> destination </td> <td> Destination resource of the operation </td> <td> </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> <td> </td> </tr> <tr> <td> hostIpAddress </td> <td> Host IP Address </td> <td> x </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> </tr> <tr> <td> role </td> <td> Cloudera Manager Role </td> <td> x </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> </tr> <tr> <td> family </td> <td> Column family </td> <td> </td> <td> </td> <td> x </td> <td> </td> <td> </td> <td> </td> </tr> <tr> <td> database_name </td> <td> Database name </td> <td> </td> <td> </td> <td> </td> <td> x </td> <td> x </td> <td> x </td> </tr> <tr> <td> table_name </td> <td> Table name </td> <td> </td> <td> </td> <td> x </td> <td> x </td> <td> x </td> <td> x </td> </tr> <tr> <td> object_type </td> <td> Type of object being handled </td> <td> </td> <td> </td> <td> </td> <td> x </td> <td> x </td> <td> x </td> </tr> <tr> <td> operation_text </td> <td> Command/query text </td> <td> </td> <td> </td> <td> </td> <td> x </td> <td> x </td> <td> x </td> </tr> </table> <p> The only supported operator is <em>\";\"</em> (Boolean AND). Boolean OR is not supported. <p> The supported comparators are <em>==</em> and <em>!=</em> Note that \"LIKE\" comparison is supported using the wild card syntax, for example <em>foo==*value*</em>. Asterisk is interpreted as a wild card character and must not be part of the value. (LIKE comparison queries are converted to standard SQL LIKE syntax, so any % (%25) character in a value that also contains a wild card will be interpreted as a wild card.) <p/> Available since API v8. A subset of these features is available since v4.") @Valid @RequestParam(value = "query", required = false) String query,@ApiParam(value = "Offset of audits to return", defaultValue = "0") @Valid @RequestParam(value = "resultOffset", required = false, defaultValue="0") Integer resultOffset,@ApiParam(value = "Start of the period to query in ISO 8601 format (defaults to 1 day ago relative to endTime).") @Valid @RequestParam(value = "startTime", required = false) String startTime) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"items\" : [ {    \"timestamp\" : \"...\",    \"service\" : \"...\",    \"username\" : \"...\",    \"impersonator\" : \"...\",    \"ipAddress\" : \"...\",    \"command\" : \"...\",    \"resource\" : \"...\",    \"operationText\" : \"...\",    \"allowed\" : true  }, {    \"timestamp\" : \"...\",    \"service\" : \"...\",    \"username\" : \"...\",    \"impersonator\" : \"...\",    \"ipAddress\" : \"...\",    \"command\" : \"...\",    \"resource\" : \"...\",    \"operationText\" : \"...\",    \"allowed\" : true  } ]}", ApiAuditList.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AuditsResourceApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "", nickname = "streamAudits", notes = "", response = Resource.class, authorizations = {
        @Authorization(value = "basic")
    }, tags={ "AuditsResource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Resource.class) })
    @RequestMapping(value = "/audits/stream",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Resource> streamAudits(@ApiParam(value = "", defaultValue = "now") @Valid @RequestParam(value = "endTime", required = false, defaultValue="now") String endTime,@ApiParam(value = "", defaultValue = "100") @Valid @RequestParam(value = "maxResults", required = false, defaultValue="100") Integer maxResults,@ApiParam(value = "") @Valid @RequestParam(value = "query", required = false) String query,@ApiParam(value = "", defaultValue = "0") @Valid @RequestParam(value = "resultOffset", required = false, defaultValue="0") Integer resultOffset,@ApiParam(value = "") @Valid @RequestParam(value = "startTime", required = false) String startTime) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("", Resource.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type ", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AuditsResourceApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}