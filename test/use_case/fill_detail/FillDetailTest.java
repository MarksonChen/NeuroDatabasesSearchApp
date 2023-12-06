package use_case.fill_detail;

import data_access.*;
import entity.FetchedData;
import entity.Query;
import org.junit.Before;
import org.junit.Test;
import use_case.query.QueryDataAccessInterface;
import use_case.star.StarDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FillDetailTest {
    private FillDetailController controller;
    //    private TestFillDetailInteractor testInteractor;
    private FillDetailInteractor interactor;
    private WebDataAccessObject webDAO;
    private ModelDBDataAccessObject modelDBDAO;
    private Query query;
    private TestFillDetailOutputBoundary fillDetailPresenter;
    private QueryDataAccessInterface queryDAO;
    private StarDataAccessInterface starDAO;

    private static class TestFillDetailOutputBoundary implements FillDetailOutputBoundary {
        boolean successCalled = false;
        boolean failureCalled = false;
        FetchedData lastData = null;

        public void prepareSuccessView(FetchedData data) {
            successCalled = true;
            lastData = data;
        }

        public void prepareFailView(String message) {
            failureCalled = true;
        }
    }

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        fillDetailPresenter = new TestFillDetailOutputBoundary();
        webDAO = new WebDataAccessObject();
        queryDAO = new InMemoryQueryDataAccessObject(new CacheDataAccessObject(), "resources/serializables/fetchedDataListArr.ser");
        queryDAO = new QueryDataAccessObject(new CacheDataAccessObject(), webDAO);
        starDAO = new StarDataAccessObject("resources/serializables/starredData.ser");
        interactor = new FillDetailInteractor(fillDetailPresenter, queryDAO, starDAO);
        controller = new FillDetailController(interactor);
        webDAO = new WebDataAccessObject();
        modelDBDAO = new ModelDBDataAccessObject(webDAO);
        query = new Query("Hippocampus");

    }

    @Test
    public void testExecute() throws IOException {
        List<FetchedData> result = modelDBDAO.query(query, 1, 1);
        FetchedData data = result.get(0);
        controller.execute(data);
    }

    @Test
    public void testExceuteEdgeCase() throws IOException {
        List<FetchedData> result = modelDBDAO.query(query, 1, 1);
        FetchedData data = result.get(0);
        starDAO.toggleStar(data);
        controller.execute(data);
    }

    @Test
    public void testQueryDAOIOException() throws IOException {
        QueryDataAccessInterface queryDAOEx = new QueryDataAccessObject(new CacheDataAccessObject(), webDAO){
            @Override
            public FetchedData fillDetails(FetchedData data) throws IOException {
                throw new IOException();
            }
        };
        FillDetailInteractor interactorEx = new FillDetailInteractor(fillDetailPresenter, queryDAOEx, starDAO);
        FillDetailController controllerEx = new FillDetailController(interactorEx);

        List<FetchedData> result = modelDBDAO.query(query, 1, 1);
        FetchedData data = result.get(0);
        controllerEx.execute(data);

        assert fillDetailPresenter.failureCalled;
    }

    @Test
    public void testStarDAOIOException() throws IOException{
        StarDataAccessInterface starDAOEx = new StarDataAccessInterface(){
            private final List<FetchedData> starredDataList = new ArrayList<>();

            @Override
            public void toggleStar(FetchedData data) {
                starredDataList.add(data);
            }

            @Override
            public List<Boolean> checkIfDataStarred(List<FetchedData> fetchedData) {
                return null;
            }

            @Override
            public List<Boolean>[] checkIfDataStarred(List<FetchedData>[] fetchedData) {
                return null;
            }

            @Override
            public Boolean dataIsStarred(FetchedData data) {
                return null;
            }

            @Override
            public List<FetchedData> getStarredDataList() {
                return starredDataList;
            }

            @Override
            public void saveStarredData() throws IOException {
                throw new IOException();
            }
            @Override
            public void clear() throws IOException {}
        };
        FillDetailInteractor interactorEx = new FillDetailInteractor(fillDetailPresenter, queryDAO, starDAOEx);
        FillDetailController controllerEx = new FillDetailController(interactorEx);

        List<FetchedData> result = modelDBDAO.query(query, 1, 1);
        FetchedData data = result.get(0);

        starDAOEx.toggleStar(data);
        controllerEx.execute(data);
    }
}

