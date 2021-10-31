package com.cgsj.client.csm;

import com.cgsj.engineer.pojo.Envelope;
import com.cgsj.engineer.pojo.Table;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.quarkus.logging.Log;
import io.quarkus.runtime.util.ExceptionUtil;
import io.restassured.http.Header;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@ApplicationScoped
public class CsmClientService {
    private ObjectMapper xmlMapper;

    @PostConstruct
    public void setXmlMapper() {
        this.xmlMapper = new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @ConfigProperty(name = "csm.appToken")
    String appToken;

    public List<Table> getEngineerTables() {
        String envelopeString = given().header(new Header("AppToken", appToken))
                .header(new Header("SOAPAction", "http://SOD.com/IDjService/GetDjListPage"))
                .header(new Header("Host", "onecsm-ct.papcn.cn:51403"))
                .contentType("text/xml; charset=utf-8")
                .body("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><GetDjListPage xmlns=\"http://SOD.com/\"><name>工程师资料列表</name><wherezip>xgD1HjvBSCerKh2W1X1IQ8/ZBAutLVthjftzWC/q1A/nHgiTd9NXWHQcTQyP9H//4IaGgk1WKyWw/PdAINADfGgyPmBJma4XgnsQ7YM2cmk=</wherezip><orderby> _ID DESC </orderby><pageSize>50</pageSize><pageIndex>1</pageIndex><userid>17131</userid><token>44636ac5-40e6-48b7-af15-7b7ee3a93e1e</token></GetDjListPage></s:Body></s:Envelope>")
                .when()
                .post("https://onecsm-ct.papcn.cn:51403/onecsm/Dj.svc")
                .asString();
        Envelope envelope;
        try {
            envelope = xmlMapper.readValue(envelopeString, Envelope.class);
            return envelope.getDataTables();
        } catch (JsonProcessingException e) {
            Log.infof("getEngineerTables error");
            return new ArrayList<>();
        }
    }

    public String login() {
        return given().header(new Header("AppToken", appToken))
                .header(new Header("SOAPAction", "http://SOD.com/ILoginService/Relogin"))
                .header(new Header("Host", "onecsm-ct.papcn.cn:51403"))
                .contentType("text/xml; charset=utf-8")
                .body("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><Relogin xmlns=\"http://SOD.com/\"><token>44636ac5-40e6-48b7-af15-7b7ee3a93e1e</token><login>TGQ0DmJc6Ov8rm52LFHGET5iQHY1mKkOIMUlkQ8BI15EeUEKJhKo9fgK2EmAH5IFPWUz/30gjFbtFQe3ZeCJzr3iJmNi5aw3CzGy1tX0gvVKWFz4oMatkN7v0ziI2w8MsKgVSILlywyf9f5zUJyiqRU1Z0iQOgRScwE3Vj7KM+A=</login><sign>d3e43bd0bfde309cb72f8e1a5fd78f05</sign><statetime>20210519223845</statetime><app>Metacube.WPF</app><client>DESKTOP-QUURCTH</client><version>5.0.21.226</version><remark>PC-Microsoft Windows NT 6.2.9200.0;0C:54:15:63:13:4D</remark></Relogin></s:Body></s:Envelope>")
                .when()
                .post("https://onecsm-ct.papcn.cn:51403/onecsm/Login.svc")
                .asString();
    }

    public List<com.cgsj.workorder.pojo.Table> getWorkOrderTables() {
        String envelopeString = given().header(new Header("AppToken", appToken))
                .header(new Header("SOAPAction", "http://SOD.com/IDjService/GetDjListPage"))
                .header(new Header("Host", "onecsm-ct.papcn.cn:51403"))
                .contentType("text/xml; charset=utf-8")
                .body("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><GetDjListPage xmlns=\"http://SOD.com/\"><name>派工单列表</name><wherezip>M3TLhNosczjylvCbdj+57LMA5Qud8PA3NNaVTkO0nZADvJI3ZxAXkFyXVFbhQ7aP3Bfc5x1w4GYM1sdutTNKEA4gdGVZ0JbRHLSBikzlfKFut7nQ8QJDq28tdPpjYXAcWYLXQ823iFeAY7fgi8BH97a5EcNrp0buTA4g358tE50=</wherezip><orderby>TSSJBZ DESC, CDCS DESC, JJBZ DESC, _INSERTTIME DESC</orderby><pageSize>50</pageSize><pageIndex>1</pageIndex><userid>17131</userid><token>44636ac5-40e6-48b7-af15-7b7ee3a93e1e</token></GetDjListPage></s:Body></s:Envelope>")
                .when()
                .post("https://onecsm-ct.papcn.cn:51403/onecsm/Dj.svc")
                .asString();
        com.cgsj.workorder.pojo.Envelope envelope;
        try {
            envelope = xmlMapper.readValue(envelopeString, com.cgsj.workorder.pojo.Envelope.class);
            return envelope.getWorkOrderList();
        } catch (JsonProcessingException e) {
            Log.infof("getEngineerTables error:%s", ExceptionUtil.generateStackTrace(e));
            return new ArrayList<>();
        }
    }

    public List<com.cgsj.workorder.pojo.Table> receiveWorkOrder() {
        String envelopeString = given().header(new Header("AppToken", appToken))
                .header(new Header("SOAPAction", "http://SOD.com/IDjService/GetDjListPage"))
                .header(new Header("Host", "onecsm-ct.papcn.cn:51403"))
                .contentType("text/xml; charset=utf-8")
                .body("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><GetDjListPage xmlns=\"http://SOD.com/\"><name>派工单列表</name><wherezip>M3TLhNosczjylvCbdj+57LMA5Qud8PA3NNaVTkO0nZADvJI3ZxAXkFyXVFbhQ7aP3Bfc5x1w4GYM1sdutTNKEA4gdGVZ0JbRHLSBikzlfKFut7nQ8QJDq28tdPpjYXAcWYLXQ823iFeAY7fgi8BH97a5EcNrp0buTA4g358tE50=</wherezip><orderby>TSSJBZ DESC, CDCS DESC, JJBZ DESC, _INSERTTIME DESC</orderby><pageSize>50</pageSize><pageIndex>1</pageIndex><userid>17131</userid><token>44636ac5-40e6-48b7-af15-7b7ee3a93e1e</token></GetDjListPage></s:Body></s:Envelope>")
                .when()
                .post("https://onecsm-ct.papcn.cn:51403/onecsm/Dj.svc")
                .asString();
        com.cgsj.workorder.pojo.Envelope envelope;
        try {
            envelope = xmlMapper.readValue(envelopeString, com.cgsj.workorder.pojo.Envelope.class);
            return envelope.getWorkOrderList();
        } catch (JsonProcessingException e) {
            Log.infof("getEngineerTables error");
            return new ArrayList<>();
        }
    }

    public Boolean receiveWorkOrder(String id) {
        String body = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><DoTransAction xmlns=\"http://SOD.com/\"><name>派工单</name><id>%s</id><actName>接收</actName><paramlist xmlns:a=\"http://schemas.datacontract.org/2004/07/SOD.Meta\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\"/><userid>17131</userid><token>44636ac5-40e6-48b7-af15-7b7ee3a93e1e</token></DoTransAction></s:Body></s:Envelope>";
        String envelopeString = given().header(new Header("AppToken", appToken))
                .header(new Header("SOAPAction", "http://SOD.com/IDjService/DoTransAction"))
                .header(new Header("Host", "onecsm-ct.papcn.cn:51403"))
                .contentType("text/xml; charset=utf-8")
                .body(String.format(body, id))
                .when()
                .post("https://onecsm-ct.papcn.cn:51403/onecsm/Dj.svc")
                .asString();
        Log.infof("receiveWorkOrder res:%s", envelopeString);

        com.cgsj.actionresult.pojo.Envelope envelope;
        try {
            envelope = xmlMapper.readValue(envelopeString, com.cgsj.actionresult.pojo.Envelope.class);
            return envelope.getResult();
        } catch (JsonProcessingException e) {
            Log.infof("receiveWorkOrder error:%s", ExceptionUtil.generateStackTrace(e));
            return false;
        }
    }

    public Boolean assignWorkOrder(com.cgsj.workorder.pojo.Table workOrder, Table engineer, LocalDate localDate) {
        String envelopeString = given().header(new Header("AppToken", appToken))
                .header(new Header("SOAPAction", "http://SOD.com/IDjService/DoTransAction"))
                .header(new Header("Host", "onecsm-ct.papcn.cn:51403"))
                .contentType("text/xml; charset=utf-8")
                .body(buildAssignData(workOrder, engineer, localDate))
                .when()
                .post("https://onecsm-ct.papcn.cn:51403/onecsm/Dj.svc")
                .asString();
        Log.infof("assignWorkOrder res:%s", envelopeString);

        com.cgsj.actionresult.pojo.Envelope envelope;
        try {
            envelope = xmlMapper.readValue(envelopeString, com.cgsj.actionresult.pojo.Envelope.class);
            return envelope.getResult();
        } catch (JsonProcessingException e) {
            Log.infof("assignWorkOrder error:%s", ExceptionUtil.generateStackTrace(e));
            return false;
        }
    }

    public String buildAssignData(com.cgsj.workorder.pojo.Table workOrder, Table engineer, LocalDate localDate) {
        String data = """
                <s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/">
                    <s:Body>
                        <DoTransAction xmlns="http://SOD.com/">
                            <name>派工单</name>
                            <id>3411058</id>
                            <actName>派单</actName>
                            <paramlist xmlns:a="http://schemas.datacontract.org/2004/07/SOD.Meta" xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%FWLX%</a:DataValue>
                                    <a:Name>FWLX</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%FWDBH%</a:DataValue>
                                    <a:Name>服务店编号</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%CPPL%</a:DataValue>
                                    <a:Name>产品品类</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%GCSBH%</a:DataValue>
                                    <a:Name>工程师编号</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%GCSXM%</a:DataValue>
                                    <a:Name>工程师姓名</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>日期</a:DataType>
                                    <a:DataValue i:type="b:dateTime" xmlns:b="http://www.w3.org/2001/XMLSchema">2021-10-30T00:00:00+08:00</a:DataValue>
                                    <a:Name>预约时间</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%SDQMC%</a:DataValue>
                                    <a:Name>地区</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%QXMC%</a:DataValue>
                                    <a:Name>区县</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%ZJDMC%</a:DataValue>
                                    <a:Name>街道</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%XXDZ% </a:DataValue>
                                    <a:Name>服务地址</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%PGLY%</a:DataValue>
                                    <a:Name>派工来源</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>日期</a:DataType>
                                    <a:DataValue i:type="b:dateTime" xmlns:b="http://www.w3.org/2001/XMLSchema">%currentTime%</a:DataValue>
                                    <a:Name>预约操作时间</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">Y</a:DataValue>
                                    <a:Name>预约标志</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%DSBZ%</a:DataValue>
                                    <a:Name>电商标志</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">16:00-18:00</a:DataValue>
                                    <a:Name>预约时段</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%SMRQ% 16:00-18:00</a:DataValue>
                                    <a:Name>预约上门时段</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>字符</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">15:59:59</a:DataValue>
                                    <a:Name>截止时间</a:Name>
                                </a:SODParamMeta>
                                <a:SODParamMeta>
                                    <a:DataItemName i:nil="true"/>
                                    <a:DataType>日期</a:DataType>
                                    <a:DataValue i:type="b:string" xmlns:b="http://www.w3.org/2001/XMLSchema">%SMRQ% 15:59:59</a:DataValue>
                                    <a:Name>最晚预约时间</a:Name>
                                </a:SODParamMeta>
                            </paramlist>
                            <userid>17131</userid>
                            <token>44636ac5-40e6-48b7-af15-7b7ee3a93e1e</token>
                        </DoTransAction>
                    </s:Body>
                </s:Envelope>""";

        return data.replace("%FWLX%", workOrder.getFWLX())
                .replace("%FWDBH%", workOrder.getFWDBH())
                .replace("%CPPL%", workOrder.getCPPL())
                .replace("%GCSBH%", engineer.getGCSBH())
                .replace("%GCSXM%", engineer.getGCSXM())
                //2021-10-30T00:00:00+08:00
                //2021-10-30T00:00:00+08:00
                .replace("%YYSJ%", localDate.atStartOfDay().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss+08:00")))
                .replace("%SDQMC%", workOrder.getSDQMC())
                .replace("%QXMC%", workOrder.getQXMC())
                .replace("%ZJDMC%", workOrder.getZJDMC())
                .replace("%XXDZ%", workOrder.getXXDZ())
                .replace("%PGLY%", workOrder.getPGLY())
                .replace("%currentTime%", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.3")))
                .replace("%DSBZ%", workOrder.getDSBZ())
                .replace("%SMRQ%", localDate.toString());
    }

}
