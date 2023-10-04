package ai.chat2db.server.web.api.http;

import ai.chat2db.server.tools.base.wrapper.result.ActionResult;
import ai.chat2db.server.tools.base.wrapper.result.DataResult;
import ai.chat2db.server.web.api.http.request.KnowledgeRequest;
import ai.chat2db.server.web.api.http.request.TableSchemaRequest;
import ai.chat2db.server.web.api.http.response.*;
import com.dtflys.forest.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Gateway 的http 服务
 *
 * @author Jiaju Zhuang
 */
@BaseRequest(
    baseURL = "{gatewayBaseUrl}"
)
public interface GatewayClientService {
    /**
     * 获取公众号的二维码
     *
     * @return
     */
    @Get("/api/client/loginQrCode")
    DataResult<QrCodeResponse> getLoginQrCode();

    /**
     * Refresh login
     *
     * @param token
     * @return
     */
    @Get("/api/client/loginStatus")
    DataResult<QrCodeResponse> getLoginStatus(@Query("token") String token);

    /**
     * 返回剩余次数
     *
     * @param key
     * @return
     */
    @Get("/api/client/remaininguses/{key}")
    DataResult<ApiKeyResponse> remaininguses(@Var("key") String key);


    /**
     * Obtain invitation QR code
     *
     * @param apiKey
     * @return
     */
    @Get("/api/client/inviteQrCode")
    DataResult<InviteQrCodeResponse> getInviteQrCode(@Query("apiKey") String apiKey);


    /**
     * save knowledge vector
     *
     * @param request
     * @return
     */
    @Post("/api/milvus/knowledge/save")
    ActionResult knowledgeVectorSave(KnowledgeRequest request);

    /**
     * save table schema vector
     *
     * @param request
     * @return
     */
    @Post("/api/milvus/schema/save")
    ActionResult schemaVectorSave(TableSchemaRequest request);

    /**
     * save knowledge vector
     *
     * @param searchVectors
     * @return
     */
    @Get("/api/milvus/knowledge/search")
    DataResult<KnowledgeResponse> knowledgeVectorSearch(List<List<BigDecimal>> searchVectors);

    /**
     * save table schema vector
     *
     * @param searchVectors
     * @return
     */
    @Get("/api/milvus/schema/search")
    DataResult<TableSchemaResponse> schemaVectorSearch(List<List<BigDecimal>> searchVectors);
}
